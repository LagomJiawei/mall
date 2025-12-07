CREATE TABLE `sys_user_role` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `user_id` bigint NOT NULL COMMENT '用户ID',
     `role_id` bigint NOT NULL COMMENT '角色ID',
     PRIMARY KEY (`id`) USING BTREE,
     KEY `index_user_id` (`user_id`) USING BTREE,
     KEY `index_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='用户角色关联关系表';