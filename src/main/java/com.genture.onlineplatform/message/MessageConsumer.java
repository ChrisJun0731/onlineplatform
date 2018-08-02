package com.genture.onlineplatform.message;

import com.genture.onlineplatform.dao.GatewayInfoDao;
import com.genture.onlineplatform.param.ResponseMessage;
import com.genture.onlineplatform.param.info.ResponseMapping;
import com.genture.onlineplatform.service.ResponseCache;
import com.rabbitmq.client.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2018/8/1.
 */
@Component
public class MessageConsumer {

	@Autowired
	private ConnectionFactory connectionFactory;
	@Autowired
	private ResponseCache responseCache;
	@Autowired
	private GatewayInfoDao gatewayInfoDao;

	private static Connection connection;

	public MessageConsumer(){
		try {
			connection = connectionFactory.newConnection();

			List<String> gatewayIds = gatewayInfoDao.getGatewayIds();
			for(String id: gatewayIds){
				newConsumer(id);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理指定队列的消息
	 * @param queueName
	 */
	public void newConsumer(String queueName){
		Channel channel = null;
		try {
			channel = connection.createChannel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties props, byte[] body) {
				try {
					String message = new String(body, "UTF-8");
					processMessage(message);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		};

		try {
			channel.basicConsume(queueName, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processMessage(String message){
		JSONObject obj = JSONObject.fromObject(message);
		String msgId = (String)obj.get("msgId");
		String status = (String) obj.get("status");
		String data = (String)obj.get("data");
		ResponseMessage respMessage = new ResponseMessage();
		respMessage.setStatus(status);
		respMessage.setData(data);
		ResponseMapping mapping = responseCache.findMappingByMsgId(msgId);
		if(mapping!=null){
			try {
				mapping.getResp().getWriter().write(JSONObject.fromObject(respMessage).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
