package com.yll.zhihu.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName zhihu
 */
@TableName(value = "zhihu")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zhihu implements Serializable {

	public static final String ZHIHU_COM = "https://www.zhihu.com/question/%s/answer/%s";

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 问题id
	 */
	private Long qId;

	/**
	 * 回答id
	 */
	private Long aId;

	/**
	 * 问题内容
	 */
	private String qDetail;

	/**
	 * 入库时间
	 */
	private Date recordDate;

	/**
	 * 最常看
	 */
	private Long weight;

	/**
	 * 投票数
	 */
	private Long voteCount;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	@TableField(exist = false)
	private String url;

	public String getUrl() {
		return String.format(ZHIHU_COM,qId,aId);
	}

}