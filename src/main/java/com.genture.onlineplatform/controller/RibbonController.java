package com.genture.onlineplatform.controller;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.service.MessageService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/17.
 */
public class RibbonController {

	@Autowired
	private MessageService messageService;

	@RequestMapping("/api/gd/band_color/{deviceId}")
	public void getRoadColor(@PathVariable("deviceId") String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.QUERY_ROAD_COLOR, resp);
	}

	@RequestMapping(value = "/api/gd/band_color/{deviceId}", method = RequestMethod.POST)
	public void setRoadColor(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.ROAD_COLOR_SET, resp);
	}

	@RequestMapping(value = "/api/gd/clear_screen", method = RequestMethod.POST)
	public void clearScreen(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.SCREEN_CLEAN, resp);
	}

	@RequestMapping(value = "/api/gd/text/{deviceId}", method = RequestMethod.GET)
	public void queryText(@PathVariable("deviceId") String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.QUERY_RIBBON_TEXT, resp);
	}

	@RequestMapping(value = "/api/gd/text/{deviceId}", method = RequestMethod.POST)
	public void editText(@PathVariable("deviceId")String deviceId, @RequestBody String data, HttpServletResponse resp){
		messageService.service(deviceId, data, MessageType.EDIT_RIBBON_TEXT, resp);
	}
}

