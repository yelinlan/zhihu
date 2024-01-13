package com.yll.zhihu.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Param {
	private Long size;
	private Long currentPage;
	private String orderBy;
	private Boolean asc;
	private String sc;
	private Long qid;
	private Long aid;
}
