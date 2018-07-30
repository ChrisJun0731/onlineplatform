package com.genture.onlineplatform.controller.ribbon;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public void setRoadColor(@PathVariable("deviceId")String deviceId, @RequestBody String data, HttpServletResponse resp){
		messageService.service(deviceId, data, MessageType.ROAD_COLOR_SET, resp);
	}
}

