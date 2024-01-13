/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : 127.0.0.1:3306
 Source Schema         : hotnews

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 13/01/2024 14:03:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zhihu
-- ----------------------------
DROP TABLE IF EXISTS `zhihu`;
CREATE TABLE `zhihu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `q_id` bigint(0) NULL DEFAULT NULL COMMENT '问题id',
  `a_id` bigint(0) NULL DEFAULT NULL COMMENT '回答id',
  `q_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '问题内容',
  `vote_count` bigint unsigned NULL COMMENT '投票数',
  `weight` bigint(0) NULL DEFAULT NULL COMMENT '最常看',
  `record_date` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83530 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
