package com.yll.zhihu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.zhihu.domain.Zhihu;
import com.yll.zhihu.service.Param;
import com.yll.zhihu.service.ZhihuService;
import com.yll.zhihu.utils.GlobalVariable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@项目名称: zhihu
 *@类名称: a
 *@类描述:
 *@创建人: yll
 *@创建时间: 2023/12/6 22:21
 **/
@Controller
@RequiredArgsConstructor
public class ZhihuController {

	private final ZhihuService zhihuService;

	@GetMapping("/forever")
	@ResponseBody
	public Object forever() {
		return GlobalVariable.start();
	}

	@GetMapping("/status")
	@ResponseBody
	public Object status() {
		return GlobalVariable.detail();
	}

	@GetMapping("/stop")
	@ResponseBody
	public Object stop() {
		return GlobalVariable.stop();
	}

	@RequestMapping("/page")
	public String findUserList(Param param, Model model) {
		// 查询用户列表 及设置分页信息
		Page<Zhihu> page = zhihuService.pageList(param);
		model.addAttribute("zhihuList", page.getRecords());
		model.addAttribute("pageInfo", page);
		return "list";
	}

	@GetMapping("/url")
	@ResponseBody
	public Object updateUrl(String url) {
		GlobalVariable.url(url);
		return GlobalVariable.URL;
	}

	@GetMapping("/vote/{num}")
	@ResponseBody
	public Object vote(@PathVariable Integer num) {
		GlobalVariable.vote(num);
		return GlobalVariable.vote();
	}

	@GetMapping("/vote")
	@ResponseBody
	public Object vote() {
		return GlobalVariable.vote();
	}

	@GetMapping("/sleep/{num}")
	@ResponseBody
	public Object sleep(@PathVariable Integer num) {
		GlobalVariable.sleep(num);
		return GlobalVariable.sleep();
	}

	@GetMapping("/sleep")
	@ResponseBody
	public Object sleep() {
		return GlobalVariable.sleep();
	}

}