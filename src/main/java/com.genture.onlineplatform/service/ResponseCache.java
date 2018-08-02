package com.genture.onlineplatform.service;

import com.genture.onlineplatform.param.info.ResponseMapping;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Component
public class ResponseCache {

	private List<ResponseMapping> cache = null;
	private final int MAX_CHECK_TIME = 10;

	public ResponseCache(){
		this.cache = new ArrayList<>();
	}

	/**
	 * 新增一个缓存对象
	 * @param responseMapping
	 */
	public synchronized void addMapping(ResponseMapping responseMapping){
		cache.add(responseMapping);
	}

	/**
	 * 从缓存中匹配msgId的对象
	 * @param msgId
	 * @return
	 */
	public synchronized ResponseMapping findMappingByMsgId(String msgId){
		int size = cache.size();
		ResponseMapping mapping = null;
		for(int i=size; i>=0; i--){
			mapping = cache.get(i);
			if (mapping.getMsgId().equals(msgId)) {
				cache.remove(mapping);
				return mapping;
			} else {
				mapping.setCheckTimes(mapping.getCheckTimes()+1);
				if (mapping.getCheckTimes() > MAX_CHECK_TIME) {
					try {
						mapping.getResp().getWriter().write("{\"status\":200,\"data\":null}");
						cache.remove(mapping);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public List<ResponseMapping> getResponseCache() {
		return cache;
	}
}
