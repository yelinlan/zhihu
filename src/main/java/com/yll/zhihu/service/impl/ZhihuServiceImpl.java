package com.yll.zhihu.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yll.zhihu.bean.Data;
import com.yll.zhihu.bean.JsonRootBean;
import com.yll.zhihu.bean.Target;
import com.yll.zhihu.domain.Zhihu;
import com.yll.zhihu.mapper.ZhihuMapper;
import com.yll.zhihu.service.Param;
import com.yll.zhihu.service.ZhihuService;
import com.yll.zhihu.utils.BaseHttp;
import com.yll.zhihu.utils.GlobalVariable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 夜林蓝
 * @description 针对表【zhihu】的数据库操作Service实现
 * @createDate 2023-12-06 22:17:33
 */
@Service
@RequiredArgsConstructor
public class ZhihuServiceImpl extends ServiceImpl<ZhihuMapper, Zhihu> implements ZhihuService {

	private final ZhihuMapper zhihuMapper;

	public void savePage() {
		try {
			String rs = BaseHttp.get(GlobalVariable.URL);
			JsonRootBean bean = JSONUtil.toBean(rs, JsonRootBean.class);
			List<Data> data = bean.getData();
			data.forEach(this::convert);
			sleep();
		} catch (Exception ignored) {
		}
	}

	private void convert(Data p) {
		try {
			Target t = p.getTarget();
			if (t.getVoteup_count() > GlobalVariable.vote()) {
				Zhihu zhihu = build(t, t.getVoteup_count(), t.getQuestion().getId(), t.getId());
				boolean exist = exist(zhihu);
				if (!exist) {
					baseMapper.insert(zhihu);
				}
			}
		} catch (Exception ignored) {
		}
	}

	private boolean exist(Zhihu zhihu) {
		LambdaQueryWrapper<Zhihu> query = Wrappers.lambdaQuery(Zhihu.class);
		query.eq(Zhihu::getQId, zhihu.getQId());
		query.eq(Zhihu::getAId, zhihu.getAId());
		return baseMapper.exists(query);
	}

	private Zhihu build(Target target, long count, long qid, long aid) {
		return Zhihu.builder().aId(aid).qId(qid).qDetail(target.getQuestion().getTitle()).recordDate(new Date())
				.voteCount(count).weight(0L).build();
	}

	private void sleep() {
		try {
			Thread.sleep(GlobalVariable.sleep());
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
	}

	public Page<Zhihu> pageList(Param param) {
		LambdaQueryWrapper<Zhihu> query = Wrappers.lambdaQuery(Zhihu.class);

		query.eq(param.getQid() != null, Zhihu::getQId, param.getQid());
		query.eq(param.getAid() != null, Zhihu::getAId, param.getAid());
		query.like(StrUtil.isNotBlank(param.getSc()), Zhihu::getQDetail, param.getSc());

		if (StrUtil.isNotBlank(param.getOrderBy())) {
			param.setAsc(param.getAsc() == null ? false : param.getAsc());
			query.last("order by " + param.getOrderBy() + " " + (param.getAsc() ? "asc" : "desc"));
		}

		param.setCurrentPage(param.getCurrentPage() == null ? 0 : param.getCurrentPage());
		param.setSize(param.getSize() == null ? 20 : param.getSize());
		Page<Zhihu> page = new Page<>(param.getCurrentPage(), param.getSize());
		return zhihuMapper.selectPage(page, query);
	}

}




