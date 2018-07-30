package com.genture.onlineplatform.controller.info;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/17.
 */
@Controller
public class InfoController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value="/api/vms_status/{deviceId}",method = RequestMethod.GET)
	public void queryVmsState(@PathVariable("deviceId")String deviceId, HttpServletResponse resp){
		messageService.service(deviceId, null, MessageType.DEVICE_STATUS, resp);
	}

	@RequestMapping("/api/vms_date/{deviceId}")
	public void queryVmsDate(@PathVariable("deviceId")String deviceId, HttpServletRequest req, HttpServletResponse resp){
		messageService.service(deviceId, null, MessageType.DEVICE_DATE, resp);
	}

	@RequestMapping("/api/vms_basic_param/{deviceId}")
	public void queryVmsBasicParam(@PathVariable("deviceId")String deviceId, HttpServletResponse resp){
		messageService.service(deviceId, null, MessageType.BASIC_PARAM, resp);
	}

	@RequestMapping("/api/processor_info/{deviceId}")
	public void queryGatewayInfo(@PathVariable("deviceId")String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.GATEWAY_INFO , resp);
	}

	@RequestMapping("/api/vms_version/{deviceId}")
	public void queryVmsVersion(@PathVariable("deviceId")String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.VERSION, resp);
	}

	@RequestMapping("/api/vms_online/{deviceId}")
	public void queryVmsOnline(@PathVariable("deviceId")String deviceId, HttpServletResponse resp){

	}

	@RequestMapping("/api/encrypt/{deviceId}")
	public void isEncrypt(@PathVariable("deviceId")String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.IS_ENCRYPT, resp);
	}

	@RequestMapping("/api/vms_screen_size/{deviceId}")
	public void queryScreenSize(@PathVariable("deviceId") String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.SCREEN_SIZE, resp);
	}

}
