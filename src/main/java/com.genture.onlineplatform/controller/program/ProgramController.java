package com.genture.onlineplatform.controller.program;

import com.genture.onlineplatform.param.MessageType;
import com.genture.onlineplatform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/17.
 */
public class ProgramController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/api/file", method = RequestMethod.POST)
	public void uploadFile(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.FILE, resp);
	}

	@RequestMapping(value = "/api/vms_program/:deviceId", method = RequestMethod.POST)
	public void uploadAndPlayProgram(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.PUSH_PROGRAM, resp);
	}

	@RequestMapping(value = "/api/program/{deviceId}", method = RequestMethod.GET)
	public void currentProgram(@PathVariable("deviceId")String deviceId, HttpServletResponse resp){
		messageService.service(deviceId, null, MessageType.PULL_PROGRAM, resp);
	}

	@RequestMapping(value = "/api/vms_program_preset/:deviceId", method = RequestMethod.POST)
	public void programPreset(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.PRESET_PROGRAM, resp);
	}

	@RequestMapping(value = "/api/vms_preset_play/:deviceId", method = RequestMethod.POST)
	public void presetProgramPlay(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp) {
		messageService.service(deviceId, data, MessageType.PLAY_PRESET, resp);
	}

	@RequestMapping(value = "/api/vms_preset_query/:deviceId", method = RequestMethod.GET)
	public void presetProgramQuery(@PathVariable("deviceId") String deviceId, HttpServletResponse resp) {
		messageService.service(deviceId, null, MessageType.PRESET_NAMES, resp);
	}

	@RequestMapping(value = "/api/vms_offline_preset/:deviceId", method = RequestMethod.POST)
	public void offlineProgramSet(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp){
		messageService.service(deviceId, data, MessageType.OFFLINE_PRESET, resp);
	}

	@RequestMapping(value="/api/vms_local_refresh", method = RequestMethod.POST)
	public void localRefresh(@PathVariable("deviceId") String deviceId, @RequestBody String data, HttpServletResponse resp){
		messageService.service(deviceId, data, MessageType.LOCAL_REFRESH, resp);
	}

	@RequestMapping(value="/api/vms_local_refresh/:deviceId", method = RequestMethod.GET)
	public void getLocalRefreshContent(@PathVariable("deviceId") String deviceId, HttpServletResponse resp){
		messageService.service(deviceId, null, MessageType.QUERY_LOCAL_REFRESH, resp);
	}
}
