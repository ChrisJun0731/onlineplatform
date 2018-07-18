package com.genture.onlineplatform.params.NetParam;

/**
 * Created by Administrator on 2018/7/17.
 */
public class Serial extends NetParam {

	private String port;
	private int bps;
	private int dataBits;
	private int endBit;
	private int valid;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}

	public int getDataBits() {
		return dataBits;
	}

	public void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	public int getEndBit() {
		return endBit;
	}

	public void setEndBit(int endBit) {
		this.endBit = endBit;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}
}
