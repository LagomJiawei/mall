CREATE TABLE `sys_role_dept` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `role_id` bigint NOT NULL COMMENT '角色ID',
     `dept_id` bigint NOT NULL COMMENT '部门ID',
     PRIMARY KEY (`id`) USING BTREE,
     KEY `index_role_id` (`role_id`) USING BTREE,
     KEY `index_dept_id` (`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色部门关联关系表';