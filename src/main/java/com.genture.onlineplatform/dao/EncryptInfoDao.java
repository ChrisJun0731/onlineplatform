package com.genture.onlineplatform.dao;

import com.genture.onlineplatform.param.info.EncryptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Component
public class EncryptInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
