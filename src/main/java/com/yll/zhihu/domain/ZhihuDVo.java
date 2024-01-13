package com.yll.zhihu.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @TableName zhihu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZhihuDVo implements Serializable {

	private String qDetail;
	private Long voteCount;
	private static final long serialVersionUID = 1L;
	private String url;

}