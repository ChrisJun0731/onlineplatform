package com.genture.onlineplatform.service;

import com.genture.onlineplatform.dao.MessageDao;
import com.genture.onlineplatform.message.RPCClient;
import com.genture.onlineplatform.param.DeviceCode;
import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.param.RequestMessage;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/25.
 */
@Service
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private RPCClient rpcClient;

	public void service(String id, String data, MessageType messageType, HttpServletResponse resp){

		RequestMessage message = new RequestMessage();
		message.setId(id);
		message.setType(messageType.type());
		message.setData(data);

		//根据设备id判断其属于前置机还是诱导屏，如果是诱导屏查其所属前置机id
		boolean isGateway = isGateway(id);
		String gatewayId = "";
		String queueName = "";
		if(isGateway){
			gatewayId = id;
		}else{
			gatewayId = messageDao.queryGatewayId(id);
		}
		if (gatewayId == null) {
			System.out.println("查找不到此诱导屏所属的前置机，请确认！");
			return;
		} else {
			queueName = gatewayId;
		}

		String result =  rpcClient.call(JSONObject.fromObject(message).toString(), queueName);

		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断该设备编码是不是前置机编码
	 * @param deviceId
	 * @return
	 */
	private boolean isGateway(String deviceId){

		DeviceCode deviceCode = DeviceCode.parseDeviceCode(deviceId);

		if (deviceCode.getDeviceTypeCode().toLowerCase() == "c0") {
			return true;
		} else {
			return false;
		}
	}
}
