/*
Navicat MySQL Data Transfer

Source Server         : vm1
Source Server Version : 50726
Source Host           : 192.168.187.201:3306
Source Database       : saber_authr

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-09-19 18:46:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_gateway_setting
-- ----------------------------
DROP TABLE IF EXISTS `app_gateway_setting`;
CREATE TABLE `app_gateway_setting` (
  `gateway_id` bigint(20) NOT NULL COMMENT '网关id',
  `app_id` bigint(20) NOT NULL,
  `app_service_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SpringCloud的serviceId,网关转发需要',
  `gateway_path` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '网关path',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`gateway_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='网关配置信息';

-- ----------------------------
-- Records of app_gateway_setting
-- ----------------------------
INSERT INTO `app_gateway_setting` VALUES ('367074032125882368', '366725073079513088', 'hello', '/**', '2019-09-05 11:42:15', '2019-09-05 11:42:15');
INSERT INTO `app_gateway_setting` VALUES ('368754752137342976', '367009437944262656', 'saber-auth', '/**', '2019-09-10 03:00:49', '2019-09-10 03:00:49');

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `app_id` bigint(20) NOT NULL,
  `app_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT 'app名字',
  `app_secret` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT 'app秘钥',
  `app_desc` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `status` tinyint(2) NOT NULL COMMENT '0-无效，1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='app信息表';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('366724743801483264', '项目一', '8253d722-73ce-40c0-b1eb-085308df8f05', '介绍1', '0', '2019-09-04 12:34:18', '2019-09-04 12:34:18');
INSERT INTO `app_info` VALUES ('366725073079513088', '应用二', '25f89638-188b-4239-b005-38b495cfc846', '22234', '1', '2019-09-04 12:35:36', '2019-09-05 06:44:18');
INSERT INTO `app_info` VALUES ('367002628747571200', '应用三', 'b093c3cd-5159-4b0e-9ad2-cbcaf1c80ddf', '1234', '1', '2019-09-05 06:58:30', '2019-09-05 06:58:30');
INSERT INTO `app_info` VALUES ('367009375134560256', '应用4', '6f1150d5-400f-4e88-a4d8-d3bfc7ef5501', null, '1', '2019-09-05 07:25:19', '2019-09-05 07:25:19');
INSERT INTO `app_info` VALUES ('367009393367199744', '应用5', '9273a4d8-e0dd-48c6-b38b-b35e0722bb0f', null, '1', '2019-09-05 07:25:24', '2019-09-05 07:25:24');
INSERT INTO `app_info` VALUES ('367009422836379648', '应用6', '7dc9c418-adb0-4a8f-8378-0dc20de993b1', null, '1', '2019-09-05 07:25:31', '2019-09-05 07:25:31');
INSERT INTO `app_info` VALUES ('367009437944262656', '应用7', '8a3f05a6-bc0c-4ce9-85e7-13518cd20f5e', null, '1', '2019-09-05 07:25:34', '2019-09-05 07:25:34');
INSERT INTO `app_info` VALUES ('367009472069120000', '应用8', '6329e138-504a-4e41-ae04-272e5d4ba252', null, '1', '2019-09-05 07:25:42', '2019-09-05 07:25:42');
INSERT INTO `app_info` VALUES ('367009493246160896', '应用9', '1e48b9db-a393-434e-a205-a08d87546033', null, '1', '2019-09-05 07:25:48', '2019-09-05 07:25:48');
INSERT INTO `app_info` VALUES ('367009508920274944', '应用10', '45cd8343-3550-44d1-a42d-04757fbb0e6f', null, '0', '2019-09-05 07:25:51', '2019-09-05 07:25:51');
INSERT INTO `app_info` VALUES ('367009522807615488', '应用11', '03a0b306-3a07-4aff-ae95-7de0a7033e21', null, '1', '2019-09-05 07:25:55', '2019-09-05 07:25:55');
INSERT INTO `app_info` VALUES ('367009628629905408', '应用12', '06e4ee7f-34e2-4de0-bbf6-1fbaaabb0e77', null, '1', '2019-09-05 07:26:20', '2019-09-05 07:26:20');

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
-- Records of app_shiro_setting
-- ----------------------------
INSERT INTO `app_shiro_setting` VALUES ('371064904781803520', '367009493246160896', '/*', 'authc', '2019-09-16 12:00:32', '2019-09-16 12:00:32');
INSERT INTO `app_shiro_setting` VALUES ('371284899835031552', '367009628629905408', '1', '1x', '2019-09-17 02:34:43', '2019-09-17 02:34:52');
INSERT INTO `app_shiro_setting` VALUES ('371284973445066752', '367009472069120000', '2', '2', '2019-09-17 02:35:01', '2019-09-17 02:35:01');
INSERT INTO `app_shiro_setting` VALUES ('371285010984087552', '367009493246160896', '4', '4', '2019-09-17 02:35:10', '2019-09-17 02:35:10');
INSERT INTO `app_shiro_setting` VALUES ('371285037584363520', '367009522807615488', '5', '5', '2019-09-17 02:35:17', '2019-09-17 02:35:17');
INSERT INTO `app_shiro_setting` VALUES ('371285060539789312', '367009393367199744', '6', '6', '2019-09-17 02:35:22', '2019-09-17 02:35:22');
INSERT INTO `app_shiro_setting` VALUES ('371285080164937728', '367009472069120000', '11', '11', '2019-09-17 02:35:27', '2019-09-17 02:35:27');
INSERT INTO `app_shiro_setting` VALUES ('371285101916598272', '367009472069120000', '12', '12', '2019-09-17 02:35:32', '2019-09-17 02:35:32');
INSERT INTO `app_shiro_setting` VALUES ('371285139896020992', '366725073079513088', '3', '421', '2019-09-17 02:35:41', '2019-09-17 02:35:41');
INSERT INTO `app_shiro_setting` VALUES ('371285156740345856', '367009472069120000', '412', '123', '2019-09-17 02:35:45', '2019-09-17 02:35:45');
INSERT INTO `app_shiro_setting` VALUES ('371285185592963072', '367009522807615488', '41', '1', '2019-09-17 02:35:52', '2019-09-17 02:35:52');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL COMMENT 'app_id',
  `permission_name` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '权限名',
  `permission_value` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '权限具体值.shiro会用到',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限点';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('371796630785110016', '367009522807615488', '删除用户1', 'delUser', null, '1', '2019-09-18 12:28:09', '2019-09-19 02:54:03');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL COMMENT 'app_id',
  `resource_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '资源名',
  `resource_value` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '资源值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL COMMENT 'appId',
  `role_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名',
  `role_value` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '角色具体值，shiro会用的',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
  `status` int(1) NOT NULL COMMENT '0-无效，1-有效',
  `type` int(1) NOT NULL COMMENT '1-普通用户，2-管理员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('371739451050831872', '367009437944262656', '操作者1', '', '123', '1', '1', '2019-09-18 08:40:57', '2019-09-18 09:03:50');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL COMMENT 'apId应用Id',
  `mail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `status` int(1) NOT NULL COMMENT '0-无效，1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('371758728285925376', '367009437944262656', '494309953@qq.com', '13187169066', 'saber', '123456', '1234', '1', '2019-09-18 09:57:33', '2019-09-18 09:57:33');

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

-- ----------------------------
-- Records of user_role
-- ----------------------------
