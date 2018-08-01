package com.genture.onlineplatform.service;

import com.genture.onlineplatform.dao.ProgramDao;
import com.genture.onlineplatform.util.CommonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class ProgramService {

	@Autowired
	private ProgramDao programDao;
	@Autowired
	private CommonUtil commonUtil;

	public String savePresetProgram(String deviceId, String data){

		List<String> playlistNames = programDao.getPlaylistNamesById(deviceId);
		JSONObject program = JSONObject.fromObject(data);
		String presetName = (String)program.get("name");
		String playlistName = newPlaylistName(getMaxNum(playlistNames));

		programDao.savePresetProgram(deviceId, presetName, playlistName);
		program.element("name", playlistName);

		return program.toString();
	}

	/**
	 * 获取预置节目中的最大编号
	 * 预置节目的范围play70.lst-play100.lst
	 * @param presetNames
	 */
	public int getMaxNum(List<String> presetNames){
		int max = 70;
		for(String presetName: presetNames){
			int temp = commonUtil.parsePlaylistNum(presetName);
			max=temp>max?temp:max;
		}
		return max;
	}

	/**
	 * 生成新的播放列表名称
	 * @param max
	 * @return
	 */
	public String newPlaylistName(int max) {
		int num = max==100?70:max+1;
		String playlistName = "play" + String.valueOf(num) + ".lst";
		return playlistName;
	}

	/**
	 * 查询预置节目对应的播放列表的名称
	 * @param deviceId
	 * @param data
	 * @return
	 */
	public String queryPlaylistName(String deviceId, String data) {
		JSONObject obj = JSONObject.fromObject(data);
		String presetName = (String)obj.get("presetName");
		String playlistName = programDao.getPlaylistNameByPresetName(deviceId, presetName);
		obj.element("presetName", playlistName);
		return obj.toString();
	}

	/**
	 * 查询该诱导屏下所有预置节目
	 * @param deviceId
	 * @return
	 */
	public List<String> queryPresetNames(String deviceId) {
		return programDao.getPresetNames(deviceId);
	}

	public String setOfflinePrograme(String deviceId, String data){
		JSONObject obj = JSONObject.fromObject(data);
		String presetName = obj.getString("presetName");
		String playlistName = programDao.getPlaylistNameByPresetName(deviceId, presetName);
		obj.element("presetName", playlistName);
		return obj.toString();
	}
}
