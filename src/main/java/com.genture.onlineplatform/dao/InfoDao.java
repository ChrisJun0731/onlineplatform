package com.genture.onlineplatform.dao;

import com.genture.onlineplatform.param.info.EncryptInfo;
import com.genture.onlineplatform.param.info.GatewayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Component
public class InfoDao {

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
	 * 查询前置机下所有诱导屏是否加密信息
	 * @param deviceId
	 * @return
	 */
	public List<EncryptInfo> queryEncryptInfoByGatewayId(String deviceId){

		String sql = "select encrypt.id, encrypt.encrypt from t_encrypt_info encrypt,t_vms_info vms where" +
				"vms.gateway_id = ? and vms.id = encrypt.id";

		List<EncryptInfo> encryptInfos = jdbcTemplate.query(sql, (rs, i)->{
			EncryptInfo encryptInfo = new EncryptInfo();
			String id = rs.getString("id");
			int encypt = rs.getInt("encrypt");
			encryptInfo.setId(id);
			encryptInfo.setEncrypt(encypt==0?false:true);
			return encryptInfo;
		}, deviceId);

		return encryptInfos;
	}

	/**
	 * 查询诱导屏是否加密信息
	 * @param deviceId
	 * @return
	 */
	public List<EncryptInfo> queryEncryptInfoById(String deviceId){

		String sql = "select id, encrypt from t_encrypt_info where id=?";

		List<EncryptInfo> encryptInfos = jdbcTemplate.query(sql, (rs, i)->{
			EncryptInfo encryptInfo = new EncryptInfo();
			String id = rs.getString("id");
			int encypt = rs.getInt("encrypt");
			encryptInfo.setId(id);
			encryptInfo.setEncrypt(encypt==0?false:true);
			return encryptInfo;
		}, deviceId);

		return encryptInfos;

	}
}
