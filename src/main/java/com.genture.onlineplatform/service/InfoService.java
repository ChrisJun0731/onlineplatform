package com.genture.onlineplatform.service;

import com.genture.onlineplatform.dao.EncryptInfoDao;
import com.genture.onlineplatform.dao.GatewayInfoDao;
import com.genture.onlineplatform.param.info.EncryptInfo;
import com.genture.onlineplatform.param.info.GatewayInfo;
import com.genture.onlineplatform.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Service
public class InfoService {

	@Autowired
	private GatewayInfoDao gatewayInfoDao;
	@Autowired
	private EncryptInfoDao encryptInfoDao;
	@Autowired
	private CommonUtil commonUtil;

	public List<GatewayInfo> queryGatewayInfo(String deviceId) {
		if(deviceId == null){
			return gatewayInfoDao.queryAllGateway();
		}else{
			return gatewayInfoDao.queryGatewayById(deviceId);
		}
	}

	public List<EncryptInfo> queryEncryptInfo(String deviceId){
		if (commonUtil.isGateway(deviceId)) {
			return encryptInfoDao.queryEncryptInfoByGatewayId(deviceId);
		} else {
			return encryptInfoDao.queryEncryptInfoById(deviceId);
		}
	}
}
