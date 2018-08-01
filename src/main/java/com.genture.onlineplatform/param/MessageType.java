package com.genture.onlineplatform.param;

/**
 * Created by Administrator on 2018/7/25.
 */
public enum MessageType {

	DEVICE_STATUS("device_stauts"),
	DEVICE_DATE("device_date"),
	BASIC_PARAM("basic_param"),
	GATEWAY_INFO("gateway_info"),
	VERSION("version"),
	DEVICE_ONLINE("device_online"),
	IS_ENCRYPT("encrypt_query"),
	SCREEN_SIZE("screen_size"),

	SCREEN_SWITCH("screen_switch"),
	BRIGHTNESS_CONTROL("brightness_control"),
	AUTO_BRIGHTNESS_PARAM("auto_brightness_param"),
	RESTART("restart"),
	VMS_ALTER("vms_alter"),
	OFFLINE_DEAL("offline_deal"),
	TEMPER_HOT("temper_hot"),
	POWER_EXCEPTION("power_exception"),
	ENCRYPT_SET("encrypt_set"),
	CROP("crop"),

	FILE("file"),
	PUSH_PROGRAM("push_program"),
	PULL_PROGRAM("pull_program"),
	PRESET_PROGRAM("preset_program"),
	PLAY_PRESET("preset_play"),
	PRESET_NAMES("preset_names"),
	OFFLINE_PRESET("offline_preset"),
	LOCAL_REFRESH("local_fresh"),
	QUERY_LOCAL_REFRESH("query_local_refresh"),

	QUERY_ROAD_COLOR("query_road_color"),
	ROAD_COLOR_SET("road_color_set"),
	SCREEN_CLEAN("clear_screen"),
	EDIT_RIBBON_TEXT("edit_ribbon_text"),
	QUERY_RIBBON_TEXT("query_ribbon_text");

	private String type;

	MessageType(String type){
		this.type = type;
	}

	public String type(){
		return this.type;
	}
}
