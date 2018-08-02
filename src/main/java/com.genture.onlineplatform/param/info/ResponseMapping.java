package com.genture.onlineplatform.param.info;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/8/1.
 */
public class ResponseMapping {

	private String msgId;
	private HttpServletResponse resp;
	private int checkTimes;

	public int getCheckTimes() {
		return checkTimes;
	}

	public void setCheckTimes(int checkTimes) {
		this.checkTimes = checkTimes;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}
}
