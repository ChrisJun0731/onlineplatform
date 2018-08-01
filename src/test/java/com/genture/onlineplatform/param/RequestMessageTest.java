package com.genture.onlineplatform.param;

import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2018/7/25.
 */
public class RequestMessageTest {

	private RequestMessage requestMessage;

	@Before
	public void init(){
		this.requestMessage = new RequestMessage();
	}

	@Test
	public void test(){
		requestMessage.setId("11");
		requestMessage.setType("22");
		requestMessage.setData("{\"version\":\"v1.0.0\"}");

		System.out.println(JSONObject.fromObject(requestMessage).toString());
	}
}