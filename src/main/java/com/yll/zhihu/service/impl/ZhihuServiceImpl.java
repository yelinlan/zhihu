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
import com.yll.zhihu.domain.ZhihuDVo;
import com.yll.zhihu.mapper.ZhihuMapper;
import com.yll.zhihu.service.Param;
import com.yll.zhihu.service.ZhihuService;
import com.yll.zhihu.utils.BaseHttp;
import com.yll.zhihu.utils.GlobalVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 夜林蓝
 * @description 针对表【zhihu】的数据库操作Service实现
 * @createDate 2023-12-06 22:17:33
 */
@Service
public class ZhihuServiceImpl extends ServiceImpl<ZhihuMapper, Zhihu> implements ZhihuService {

	@Autowired
	private ZhihuMapper zhihuMapper;
	private int total = 0;
	private List<ZhihuDVo> rt = new ArrayList<>();
	private List<ZhihuDVo> all = new ArrayList<>();

	public List<ZhihuDVo> savePage() {
		rt.clear();
		try {
			String rs = BaseHttp.get(GlobalVariable.URL);
			JsonRootBean bean = JSONUtil.toBean(rs, JsonRootBean.class);
			List<Data> data = bean.getData();
			data.forEach(this::convert);
			sleep();
		} catch (Exception e) {
		}
		all.addAll(rt);
		return rt;
	}

	@Override
	public List<ZhihuDVo> savePage(int num) {
		all.clear();
		total = 0;
		while (total < num) {
			savePage();
		}
		return all.stream().sorted((a, b) -> -Long.compare(a.getVoteCount(), b.getVoteCount())).collect(Collectors.toList());
	}

	private void convert(Data p) {
		try {
			Target t = p.getTarget();
			if (t.getVoteup_count() > 1000) {
				Zhihu zhihu = build(t, t.getVoteup_count(), t.getQuestion().getId(), t.getId());
				boolean exist = exist(zhihu);
				if (!exist) {
					baseMapper.insert(zhihu);
				}
				total++;
				rt.add(build(zhihu));
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

	private ZhihuDVo build(Zhihu zhihu) {
		return ZhihuDVo.builder().qDetail(zhihu.getQDetail()).voteCount(zhihu.getVoteCount()).url(zhihu.getUrl())
				.build();
	}

	private Zhihu build(Target target, long count, long qid, long aid) {
		return Zhihu.builder().aId(aid).qId(qid).qDetail(target.getQuestion().getTitle()).recordDate(new Date())
				.voteCount(count).weight(0L).build();
	}

	private void sleep() {
		try {
			Thread.sleep(1000L);
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

	@Override
	public void distinct() {
		LambdaQueryWrapper<Zhihu> query = Wrappers.lambdaQuery(Zhihu.class);
		query.select(Zhihu::getId, Zhihu::getQId, Zhihu::getAId);
		List<Zhihu> list = baseMapper.selectList(query);
		Map<String, List<Zhihu>> map = list.stream().collect(Collectors.groupingBy(p -> p.getQId() + "-" + p.getAId()));
		List<Zhihu> ls = new ArrayList<>();
		map.values().stream().filter(p -> p.size() > 1).forEach(p -> {
			ls.addAll(p);
			ls.remove(ls.size() - 1);
		});
		List<Long> ids = ls.stream().map(Zhihu::getId).collect(Collectors.toList());
		baseMapper.deleteBatchIds(ids);
	}


}




