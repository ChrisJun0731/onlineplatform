package com.genture.onlineplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/26.
 */
@Component
public class MessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询前置机id
	 * @param deviceId
	 * @return
	 */
	public String queryGatewayId(String deviceId){
		String sql = "select gateway_id from t_vms_info where id = ?";
		return jdbcTemplate.queryForObject(sql, (rs, i) -> {
			String id = rs.getString("gateway_id");
			return id;
		}, deviceId);
	}
}
