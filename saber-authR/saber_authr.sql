/*
Navicat MySQL Data Transfer

Source Server         : vm1
Source Server Version : 50726
Source Host           : 192.168.187.201:3306
Source Database       : saber_authr

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-19 20:35:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `app_id` bigint(20) NOT NULL,
  `app_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT 'app名字',
  `app_service_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SpringCloud的serviceId,网关转发需要',
  `app_secret` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT 'app秘钥',
  `app_desc` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `status` tinyint(2) NOT NULL COMMENT '0-无效，1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='app信息表';

-- ----------------------------
-- Table structure for app_shiro_setting
-- ----------------------------
DROP TABLE IF EXISTS `app_shiro_setting`;
CREATE TABLE `app_shiro_setting` (
  `setting_id` bigint(20) NOT NULL COMMENT '配置id',
  `app_id` bigint(20) NOT NULL COMMENT 'appId',
  `shiro_path` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT 'shiro的权限eg.(/test/*,/**)这样的路径',
  `shiro_auth` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT 'shiro中的权限。eg(authc,anon)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='app设置shiro权限配置';

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `permission_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限点';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
  `status` int(1) NOT NULL COMMENT '0-正常，1-删除',
  `type` int(1) NOT NULL COMMENT '1-普通用户，2-管理员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `mail` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `status` int(11) NOT NULL COMMENT '用户状态(0-正常，1-已删除)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关系表';
