package com.genture.onlineplatform.message;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.param.RequestMessage;
import com.genture.onlineplatform.param.info.ResponseMapping;
import com.genture.onlineplatform.service.ResponseCache;
import com.genture.onlineplatform.util.CommonUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2018/8/1.
 */
@Component
public class MessageProducer {

	@Autowired
	private ConnectionFactory connectionFactory;
	@Autowired
	private ResponseCache responseCache;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private MessageDao messageDao;

	private static Connection connection;

	public MessageProducer(){
		try {
			connection = connectionFactory.newConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 向队列发送消息
	 * @param message
	 * @param queueName
	 */
	public void sendMessage(String id, String data, MessageType messageType, HttpServletResponse resp){
		try {
			RequestMessage message = new RequestMessage();
			String msgId = UUID.randomUUID().toString();
			message.setMsgId(msgId);
			message.setId(id);
			message.setData(data);
			message.setType(messageType.type());

			ResponseMapping mapping = new ResponseMapping();
			mapping.setMsgId(msgId);
			mapping.setResp(resp);

			boolean isGatewayId = commonUtil.isGateway(id);
			String queueName = "";
			if (isGatewayId) {
				queueName = id;
			}else{
				queueName = messageDao.queryGatewayId(id);
			}
			if(queueName != null && !queueName.equals("")){
				Channel channel = connection.createChannel();
				channel.basicPublish("", queueName, null,
						JSONObject.fromObject(message).toString().getBytes("UTF-8"));
				responseCache.addMapping(mapping);
			}else{
				System.out.println("此id："+id+" 设备不存在，请确认！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
