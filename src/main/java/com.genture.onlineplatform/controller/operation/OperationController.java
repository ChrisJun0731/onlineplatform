package com.genture.onlineplatform.controller.operation;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/17.
 */
public class OperationController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/api/vms_screen_switch", method = RequestMethod.POST)
	public void screenSwitch(@PathVariable("deviceId") String deviceId,@RequestBody String data,  HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.SCREEN_SWITCH, resp);
	}

	@RequestMapping(value = "/api/vms_brightness", method = RequestMethod.POST)
	public void brightnessControl(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.BRIGHTNESS_CONTROL, resp);
	}

	@RequestMapping(value = "/api/vms_brightness_param", method = RequestMethod.POST)
	public void autoBrightness(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.AUTO_BRIGHTNESS_PARAM, resp);
	}

	@RequestMapping(value = "/api/vms_restart", method = RequestMethod.POST)
	public void restart(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.RESTART, resp);
	}

	@RequestMapping(value = "/api/vms", method = RequestMethod.PUT)
	public void alterVmsInfo(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.VMS_ALTER, resp);
	}

	@RequestMapping(value = "/api/vms_offline_deal", method = RequestMethod.POST)
	public void offlineDeal(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.OFFLINE_DEAL, resp);
	}

	@RequestMapping(value = "/api/vms_high_temper_deal", method = RequestMethod.POST)
	public void highTemperDeal(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.TEMPER_HOT, resp);
	}

	@RequestMapping(value = "/api/vms_power_exception", method = RequestMethod.POST)
	public void powerException(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.POWER_EXCEPTION, resp);
	}

	@RequestMapping(value = "/api/vms_encrypt", method = RequestMethod.POST)
	public void encrypt(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.ENCRYPT_SET, resp);
	}

	@RequestMapping(value = "/api/vms_crop", method = RequestMethod.POST)
	public void crop(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.CROP, resp);
	}

	@RequestMapping(value = "/api/clear_screen", method = RequestMethod.POST)
	public void clearScreen(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.SCREEN_CLEAN, resp);
	}
}
