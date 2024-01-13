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
	private final Map<String, Integer> intType = new ConcurrentHashMap<>();
	public static final String RUNNING = "running";
	public static final String VOTE_NUM = "vote";
	public static final String SLEEP = "sleep";
	public static String URL = "https://www.zhihu.com/api/v3/feed/topstory/recommend?action=down&ad_interval=-10&after_id=5&desktop=true&page_number=2";

	static {
		status.put(RUNNING, true);
		intType.put(VOTE_NUM, 1000);
		intType.put(SLEEP, 1000);
	}

	public void url(String url) {
		URL = url;
	}

	public void vote(Integer num) {
		if (num != null && num > 0) {
			intType.put(VOTE_NUM, num);
		}
	}

	public Integer vote() {
		return intType.get(VOTE_NUM);
	}

	public void sleep(Integer num) {
		if (num != null && num > 0) {
			intType.put(SLEEP, num);
		}
	}

	public Integer sleep() {
		return intType.get(SLEEP);
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