/*
Navicat MySQL Data Transfer

Source Server         : vm1
Source Server Version : 50726
Source Host           : 192.168.187.201:3306
Source Database       : saber_auth

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-02 19:26:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sb_app_info
-- ----------------------------
DROP TABLE IF EXISTS `sb_app_info`;
CREATE TABLE `sb_app_info` (
                               `app_id` bigint(20) NOT NULL,
                               `app_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT 'app名字',
                               `app_secret` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT 'app秘钥',
                               `app_desc` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
                               `status` tinyint(2) NOT NULL COMMENT '0-无效，1-有效',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL COMMENT '更新时间',
                               PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_dept
-- ----------------------------
DROP TABLE IF EXISTS `sb_dept`;
CREATE TABLE `sb_dept` (
                           `dept_id` bigint(20) NOT NULL,
                           `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_time` datetime NOT NULL,
                           `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `parent_id` bigint(20) NOT NULL,
                           `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                           `seq` int(11) NOT NULL,
                           PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_permission
-- ----------------------------
DROP TABLE IF EXISTS `sb_permission`;
CREATE TABLE `sb_permission` (
                                 `permission_id` bigint(20) NOT NULL,
                                 `permission_module_id` bigint(20) NOT NULL,
                                 `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                 `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                 `operate_time` datetime NOT NULL,
                                 `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                 `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `seq` int(11) NOT NULL,
                                 `status` int(11) NOT NULL,
                                 `type` int(11) NOT NULL,
                                 `url` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                 PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_permission_module
-- ----------------------------
DROP TABLE IF EXISTS `sb_permission_module`;
CREATE TABLE `sb_permission_module` (
                                        `permission_module_id` bigint(20) NOT NULL,
                                        `parent_id` bigint(20) NOT NULL,
                                        `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                        `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                        `operate_time` datetime NOT NULL,
                                        `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                        `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                                        `seq` int(11) NOT NULL,
                                        `status` int(11) NOT NULL,
                                        PRIMARY KEY (`permission_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_role`;
CREATE TABLE `sb_role` (
                           `role_id` bigint(20) NOT NULL,
                           `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_time` datetime NOT NULL,
                           `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `status` int(11) NOT NULL,
                           `type` int(11) NOT NULL,
                           PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sb_role_permission`;
CREATE TABLE `sb_role_permission` (
                                      `role_permission_id` bigint(20) NOT NULL,
                                      `role_id` bigint(20) NOT NULL,
                                      `permission_id` bigint(20) NOT NULL,
                                      `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                      `operate_time` datetime NOT NULL,
                                      `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                      PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_user
-- ----------------------------
DROP TABLE IF EXISTS `sb_user`;
CREATE TABLE `sb_user` (
                           `user_id` bigint(20) NOT NULL,
                           `dept_id` bigint(20) NOT NULL,
                           `mail` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `operate_time` datetime NOT NULL,
                           `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           `password` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
                           `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
                           `status` int(11) NOT NULL,
                           `telephone` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                           PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_user_role`;
CREATE TABLE `sb_user_role` (
                                `user_role_id` bigint(20) NOT NULL,
                                `role_id` bigint(20) NOT NULL,
                                `user_id` bigint(20) NOT NULL,
                                `operate_ip` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                `operate_time` datetime NOT NULL,
                                `operator` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                                PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
