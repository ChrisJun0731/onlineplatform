package com.genture.onlineplatform.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/7/31.
 */
public class CommonUtilTest {

	private CommonUtil commonUtil;

	@Before
	public void setUp(){
		commonUtil = new CommonUtil();
	}

	@Test
	public void parsePlaylistNum() throws Exception {
		System.out.println(commonUtil.parsePlaylistNum("play70.lst"));
		System.out.println(commonUtil.parsePlaylistNum("play100.lst"));
	}

}