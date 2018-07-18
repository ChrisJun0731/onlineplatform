package com.genture.onlineplatform.params.NetParam;

/**
 * Created by Administrator on 2018/7/17.
 */
public class Ethernet extends NetParam{

	private String ip;
	private String port;
	private String mask;
	private String gate;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}
}
