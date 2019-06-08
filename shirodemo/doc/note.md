## 基本需求
  用户的增删改查
  角色的增删改
  资源权限的增删改
  一个用户可以多个角色
  一个角色可以多个资源权限
  
## 数据库表的创建

### 数据库脚本
```sql
-- 用户
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(20) DEFAULT NULL COMMENT '登陆帐户',
  `user_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_type` varchar(2) DEFAULT '1' COMMENT '用户类型(1普通用户2管理员3系统用户)',
  `user_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `name_pinyin` varchar(64) DEFAULT NULL COMMENT '姓名拼音',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别(0:未知;1:男;2:女)',
  `avatar` varchar(500) DEFAULT NULL COMMENT '头像',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  -- `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  -- `wei_xin` varchar(32) DEFAULT NULL COMMENT '微信',
  -- `wei_bo` varchar(32) DEFAULT NULL COMMENT '微博',
  -- `qq_` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `birth_day` date DEFAULT NULL COMMENT '出生日期',
  -- `dept_id` bigint(20) DEFAULT NULL COMMENT '部门编号',
  `position` varchar(64) DEFAULT NULL COMMENT '职位',
  `address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `staff_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `enabled` tinyint(1) DEFAULT '1',
  `remark` varchar(1024) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`),
	INDEX `enabled` (`enabled`)
) ENGINE=InnoDB COMMENT='用户管理';

-- 角色
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '所属部门编号',
  `role_type` int(1) NOT NULL DEFAULT '1' COMMENT '角色类型(1:业务角色;2:管理角色 ;3:系统内置角色)',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='角色信息表';


-- 菜单
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` varchar(2) DEFAULT '2' COMMENT '菜单类型(0:CURD;1:系统菜单;2:业务菜单;)',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级菜单编号',
  `icon_cls` varchar(50) DEFAULT NULL COMMENT '节点图标CSS类名',
  `request_url` varchar(100) DEFAULT NULL COMMENT '请求地址',
  `expand_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '展开状态(1:展开;0:收缩)',
  `sort_no` int(2) DEFAULT NULL COMMENT '排序号',
  `is_show` tinyint(1) NOT NULL DEFAULT '1' COMMENT '叶子节点(0:树枝节点;1:叶子节点)',
  `permission_flag` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `enabled` tinyint(1) DEFAULT '1',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
	INDEX `menu_name` (`menu_name`),
	INDEX `parent_id` (`parent_id`)
) ENGINE=InnoDB COMMENT='菜单';

-- 用户角色关系
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `remark` varchar(5000) DEFAULT NULL,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_role_id` (`user_id`,`role_id`)
) ENGINE=InnoDB COMMENT='用户授权表';


-- 角色权限关系
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  `permission_flag` varchar(50) NOT NULL COMMENT '权限标识',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `remark` varchar(5000) DEFAULT NULL,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_menu_key1` (`role_id`,`menu_id`,`permission_flag`)
) ENGINE=InnoDB COMMENT='角色授权表';


-- 操作日志表

```

## 项目技术
- lombok
- mybatis
- mybatis-plus
- spring
- springmvc

> 引入mybatis-plus时,不需要引入mybatis和mybatis-spring,通过mybatis-plus自动引入
