package com.genture.onlineplatform.service;

import com.genture.onlineplatform.dao.InfoDao;
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
	private InfoDao infoDao;
	@Autowired
	private CommonUtil commonUtil;

	public List<GatewayInfo> queryGatewayInfo(String deviceId) {
		if(deviceId == null){
			return infoDao.queryAllGateway();
		}else{
			return infoDao.queryGatewayById(deviceId);
		}
	}

	public List<EncryptInfo> queryEncryptInfo(String deviceId){
		if (commonUtil.isGateway(deviceId)) {
			return infoDao.queryEncryptInfoByGatewayId(deviceId);
		} else {
			return infoDao.queryEncryptInfoById(deviceId);
		}
	}
}
