package com.yll.zhihu.starter;

import com.yll.zhihu.service.ZhihuService;
import com.yll.zhihu.utils.GlobalVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *@项目名称: zhihu
 *@类名称: CatchStarter
 *@类描述:
 *@创建人: yll
 *@创建时间: 2023/12/6 23:21
 **/
@Slf4j
@Component
public class CatchStarter implements CommandLineRunner {

	@Autowired
	private ZhihuService zhihuService;

	@Override
	public void run(String... args) {
		log.info("===============全局监听器启动！===============");
		while (GlobalVariable.running()) {
			zhihuService.savePage();
		}
	}
}