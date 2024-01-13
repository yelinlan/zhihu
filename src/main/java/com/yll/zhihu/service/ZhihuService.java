package com.yll.zhihu.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yll.zhihu.domain.Zhihu;
import com.yll.zhihu.domain.ZhihuDVo;

import java.util.List;

/**
 * @author 夜林蓝
 * @description 针对表【zhihu】的数据库操作Service
 * @createDate 2023-12-06 22:17:33
 */
public interface ZhihuService extends IService<Zhihu> {

	List<ZhihuDVo> savePage();

	List<ZhihuDVo> savePage(int num);

	Page<Zhihu> pageList(Param param);

	void distinct();
}
