DROP TABLE IF EXISTS `sb_permission`;
CREATE TABLE `sb_permission` (
`permission_id`  bigint(15) NOT NULL ,
`permission_module_id`  bigint(15) NOT NULL ,
`name`  varchar(255) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time` datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
`remark`  varchar(255) NULL DEFAULT NULL ,
`seq`  int(11) NOT NULL ,
`status`  int(11) NOT NULL ,
`type`  int(11) NOT NULL ,
`url`  varchar(255) NOT NULL ,
PRIMARY KEY (`permission_id`)
);

DROP TABLE IF EXISTS `sb_permission_module`;
CREATE TABLE `sb_permission_module` (
`permission_module_id` bigint(15) NOT NULL ,
`parent_id`  bigint(15) NOT NULL ,
`name`  varchar(255) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
`remark`  varchar(255) NULL DEFAULT NULL ,
`seq`  int(11) NOT NULL ,
`status`  int(11) NOT NULL ,
PRIMARY KEY (`permission_module_id`)
);

DROP TABLE IF EXISTS `sb_dept`;
CREATE TABLE `sb_dept` (
`dept_id`  bigint(15) NOT NULL ,
`name`  varchar(255) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
`parent_id`  bigint(15) NOT NULL ,
`remark`  varchar(255) NULL DEFAULT NULL ,
`seq`  int(11) NOT NULL ,
PRIMARY KEY (`dept_id`)
);

DROP TABLE IF EXISTS `sb_role`;
CREATE TABLE `sb_role` (
`role_id` bigint(15) NOT NULL ,
`name`  varchar(255) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
`remark`  varchar(255) NOT NULL ,
`status`  int(11) NOT NULL ,
`type`  int(11) NOT NULL ,
PRIMARY KEY (`role_id`)
);

DROP TABLE IF EXISTS `sb_user`;
CREATE TABLE `sb_user` (
`user_id`  bigint(15) NOT NULL ,
`dept_id`  bigint(15) NOT NULL ,
`mail`  varchar(255)  NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
`username`  varchar(255) NOT NULL ,
`password`  varchar(255) NULL DEFAULT '' ,
`remark`  varchar(255) NULL DEFAULT '' ,
`status`  int(11) NOT NULL ,
`telephone`  varchar(255) NOT NULL,
PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `sb_role_permission`;
CREATE TABLE `sb_role_permission` (
`role_permission_id`  bigint(15) NOT NULL,
`role_id`  bigint(15) NOT NULL ,
`permission_id`  bigint(15) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
PRIMARY KEY (`role_permission_id`)
);

DROP TABLE IF EXISTS `sb_user_role`;
CREATE TABLE `sb_user_role` (
`user_role_id`  bigint(15) NOT NULL,
`role_id`  bigint(15) NOT NULL ,
`user_id`  bigint(15) NOT NULL ,
`operate_ip`  varchar(255) NOT NULL ,
`operate_time`  datetime NOT NULL ,
`operator`  varchar(255) NOT NULL ,
PRIMARY KEY (`user_role_id`)
);










