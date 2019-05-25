create database if not exists db_user;

use db_user;

DROP TABLE IF EXISTS db_user.`user`;
CREATE TABLE db_user.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `pwd` varchar(64) NOT NULL COMMENT '密码 md5加密',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `valid` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1有效 0无效',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `created_at` datetime(3) NOT NULL COMMENT '创建时间，毫秒',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_at` datetime(3) DEFAULT NULL COMMENT '更新时间，毫秒',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='kpi数据表';