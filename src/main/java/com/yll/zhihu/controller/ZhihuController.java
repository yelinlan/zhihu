package com.yll.zhihu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yll.zhihu.domain.Zhihu;
import com.yll.zhihu.domain.ZhihuDVo;
import com.yll.zhihu.service.Param;
import com.yll.zhihu.service.ZhihuService;
import com.yll.zhihu.utils.GlobalVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@项目名称: zhihu
 *@类名称: a
 *@类描述:
 *@创建人: yll
 *@创建时间: 2023/12/6 22:21
 **/
@Controller
public class ZhihuController {

	@Autowired
	private ZhihuService zhihuService;

	@GetMapping("/save")
	public String save(Model model) {
		List<ZhihuDVo> zhihuDVos = zhihuService.savePage();
		model.addAttribute("zhihuList", zhihuDVos);
		return "list";
	}

	@GetMapping("/save/{num}")
	public String save(@PathVariable("num") int num, Model model) {
		List<ZhihuDVo> zhihuDVos = zhihuService.savePage(num);
		model.addAttribute("zhihuList", zhihuDVos);
		return "list";
	}

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
	public String findUserList(Param param, Model model) throws Exception {
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

	@GetMapping("/distinct")
	@ResponseBody
	public Object distinct() {
		zhihuService.distinct();
		return "清除重复数据";
	}

	//POST http://localhost:8080/page
	//Content-Type: application/json
	//
	//{
	//    "size": 20,
	//    "current": 1,
	//    "orderby": "",
	//    "asc": false,
	//    "sc": "",
	//    "qid": 0,
	//    "aid": 0
	//}

}