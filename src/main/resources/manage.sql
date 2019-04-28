DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级部门ID 第一级为0',
  `dept_name` varchar(30) NOT NULL DEFAULT '' COMMENT '部门名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';


DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(30) NOT NULL DEFAULT '' COMMENT '登录账号',
  `dept_id` int(11) NOT NULL DEFAULT '-1' COMMENT '部门ID',
  `nick_name` varchar(30) NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `sex` smallint(6) DEFAULT '0' COMMENT '性别 0男 1女',
  `avatar` varchar(128) NOT NULL DEFAULT '' COMMENT '头像URL',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(50) NOT NULL COMMENT '盐值',
  `last_login_time` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '最后登录时间',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `status` smallint(6) DEFAULT '1' COMMENT '状态 0锁定 1正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(30) NOT NULL DEFAULT '' COMMENT '菜单/按钮名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级菜单ID 顶级菜单为0',
  `url` varchar(128) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `type` smallint(6) DEFAULT '0' COMMENT '类型 0菜单 1按钮',
  `icon` varchar(128) NOT NULL DEFAULT '' COMMENT '图标',
  `order_num` int(11) DEFAULT '-1' COMMENT '排序 按钮为-1',
  `perms` varchar(128) NOT NULL DEFAULT '' COMMENT '权限标识',
  `description` varchar(128) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';


DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关联表';


DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单权限关联表';

DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation` varchar(50) NOT NULL DEFAULT '' COMMENT '操作内容',
  `login_name` varchar(30) NOT NULL DEFAULT '' COMMENT '操作用户（登录名）',
  `url` varchar(1024) NOT NULL DEFAULT '' COMMENT '请求URL',
  `method` varchar(1024) NOT NULL DEFAULT '' COMMENT '方法名称',
  `params` varchar(2048) NOT NULL DEFAULT '' COMMENT '方法参数',
  `ip` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者IP',
  `location` varchar(128) DEFAULT '' COMMENT '操作者地点',
  `time` int(11) NOT NULL DEFAULT '-1' COMMENT '耗时 ms',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';