package com.genture.onlineplatform.util;

import com.genture.onlineplatform.param.DeviceCode;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/30.
 */
@Component
public class CommonUtil {

	/**
	 * 判断该设备编码是不是前置机编码
	 * @param deviceId
	 * @return
	 */
	public boolean isGateway(String deviceId){

		DeviceCode deviceCode = DeviceCode.parseDeviceCode(deviceId);

		if (deviceCode.getDeviceTypeCode().toLowerCase() == "c0") {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据播放列表的名称，获取节目编号
	 * @param playlistName
	 * @return
	 */
	public int parsePlaylistNum(String playlistName){
		String num = playlistName.substring(4, playlistName.lastIndexOf('.'));
		return Integer.parseInt(num);
	}
}
