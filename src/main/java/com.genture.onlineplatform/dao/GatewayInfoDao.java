package com.genture.onlineplatform.dao;

import com.genture.onlineplatform.param.info.GatewayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Component
public class GatewayInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询所有前置机信息
	 * @return
	 */
	public List<GatewayInfo> queryAllGateway(){

		String sql = "select id,name,network_id,version from t_gateway_info where status=1";

		List<GatewayInfo> gatewayInfos = new ArrayList<>();
		gatewayInfos = jdbcTemplate.query(sql, (rs, i)->{
			GatewayInfo gatewayInfo = new GatewayInfo();
			String id = rs.getString("id");
			String name = rs.getString("name");
			String ip = rs.getString("ip");
			int port = rs.getInt("port");
			String version = rs.getString("version");

			gatewayInfo.setId(id);
			gatewayInfo.setName(name);
			gatewayInfo.setIp(ip);
			gatewayInfo.setPort(port);
			gatewayInfo.setVersion(version);

			return gatewayInfo;
		});

		return gatewayInfos;
	}

	/**
	 * 查询单个前置机信息
	 * @param deviceId
	 * @return
	 */
	public List<GatewayInfo> queryGatewayById(String deviceId){

		String sql = "select id, name, ip, port, version from t_gateway_info where id = ?";

		return jdbcTemplate.query(sql, (rs,i)->{
			GatewayInfo gatewayInfo = new GatewayInfo();
			String id = rs.getString("id");
			String name = rs.getString("name");
			String ip = rs.getString("ip");
			int port = rs.getInt("port");
			String version = rs.getString("version");

			gatewayInfo.setId(id);
			gatewayInfo.setName(name);
			gatewayInfo.setIp(ip);
			gatewayInfo.setPort(port);
			gatewayInfo.setVersion(version);

			return gatewayInfo;
		},deviceId);
	}

	/**
	 * 查询前置机id
	 * @param deviceId
	 * @return
	 */
	public String queryGatewayId(String deviceId){
		String sql = "select gateway_id from t_vms_info where id = " + deviceId ;
		return jdbcTemplate.queryForObject(sql, String.class);
	}

	/**
	 * 查询所有有效前置机id
	 * @return
	 */
	public List<String> getGatewayIds(){
		String sql = "select id from t_gateway_info where status = 1";
		List<String> gatewayIds = jdbcTemplate.query(sql, (rs, i) -> rs.getString("id"));
		return gatewayIds;
	}
}
