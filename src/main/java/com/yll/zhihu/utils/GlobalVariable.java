package com.yll.zhihu.utils;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@项目名称: zhihu
 *@类名称: GlobalVariable
 *@类描述:
 *@创建人: yll
 *@创建时间: 2023/12/6 23:14
 **/
@UtilityClass
public class GlobalVariable {

	private final Map<String, Boolean> status = new ConcurrentHashMap<>();
	public static final String RUNNING = "running";
	public static String URL = "https://www.zhihu.com/api/v3/feed/topstory/recommend?action=down&ad_interval=-10&after_id=5&desktop=true&page_number=2";

	static {
		status.put(RUNNING, false);
	}

	public void url(String url){
		URL = url;
	}

	public Map<String, Boolean> start() {
		status.put(RUNNING, true);
		return status;
	}

	public Map<String, Boolean> stop() {
		status.put(RUNNING, false);
		return status;
	}

	public Map<String, Boolean> detail() {
		return status;
	}

	public Boolean running() {
		return status.get(RUNNING);
	}


}