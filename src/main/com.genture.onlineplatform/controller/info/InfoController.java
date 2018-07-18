package com.genture.onlineplatform.controller.info;

import com.genture.onlineplatform.params.NetParam.NetParam;
import com.genture.onlineplatform.params.info.VmsState;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */
public class InfoController {

	@RequestMapping("/api/vms_status/:deviceId")
	public VmsState queryVmsState(){

	}

	@RequestMapping("/api/vms_date/:deviceId")
	public String queryVmsDate(){

	}

	@RequestMapping("/api/vms_basic_param/:deviceId")
	public List<NetParam> queryVmsBasicParam(){

	}

	@RequestMapping("/api/vms_version/:deviceId")
	public String queryVmsVersion(){

	}

	@RequestMapping("/api/vms_version/:deviceId")
	public String queryVmsOnline(){

	}

	@RequestMapping("/api/vms_screen_size/:deviceId")
	public String queryScreenSize(){

	}



}
