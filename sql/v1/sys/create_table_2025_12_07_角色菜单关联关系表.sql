CREATE TABLE `sys_role_menu` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `role_id` bigint NOT NULL COMMENT '角色ID',
     `menu_id` bigint NOT NULL COMMENT '菜单ID',
     PRIMARY KEY (`id`) USING BTREE,
     KEY `index_role_id` (`role_id`) USING BTREE,
     KEY `index_menu_id` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联关系表';