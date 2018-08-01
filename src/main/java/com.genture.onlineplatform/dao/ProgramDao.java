package com.genture.onlineplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/31.
 */
@Component
public class ProgramDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询诱导屏所有预置播放列表名称
	 * @param deviceId
	 * @return
	 */
	public List<String> getPlaylistNamesById(String deviceId){
		String sql = "select playlistName from t_preset_program_info where deviceId = ?";
		List<String> presetNames = jdbcTemplate.query(sql, (rs, i)-> rs.getString("playlistName"), deviceId);
		return presetNames;
	}

	/**
	 * 存储预置节目
	 * @param deviceId
	 * @param presetName
	 * @param playlistName
	 */
	public void savePresetProgram(String deviceId, String presetName, String playlistName) {
		String id = UUID.randomUUID().toString();
		String sql = "insert into t_preset_program_info(id,deviceId,presetName,playlistName" +
				" values('" + id + "','" + deviceId + "','" + presetName + "','" +playlistName +
				"'";
		jdbcTemplate.execute(sql);
	}

	/**
	 * 根据设备号和预置节目名称查询播放列表名称
	 * @param deviceId
	 * @param presetName
	 * @return
	 */
	public String getPlaylistNameByPresetName(String deviceId, String presetName) {
		String sql = "select playlistName from t_preset_program_info where deviceId=? and presetName = ?";
		String playlistName = jdbcTemplate.queryForObject(sql, (rs, i) -> rs.getString("playlistName"),
				deviceId, presetName);
		return playlistName;
	}

	public List<String> getPresetNames(String deviceId) {
		String sql = "select presetName from t_preset_program_info where deviceID=?";
		return jdbcTemplate.query(sql, (rs, i) -> rs.getString("presetName"), deviceId);
	}

}
