CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(30) NOT NULL COMMENT '角色名称',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `data_scope` varchar(255) DEFAULT NULL COMMENT '数据权限',
    `level` int DEFAULT NULL COMMENT '角色级别',
    `permission` varchar(255) DEFAULT NULL COMMENT '功能权限',
    `create_user_id` bigint NOT NULL COMMENT '创建人ID',
    `create_user_name` varchar(30) NOT NULL COMMENT '创建人名称',
    `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
    `update_user_id` bigint DEFAULT NULL COMMENT '修改人ID',
    `update_user_name` varchar(30)  DEFAULT NULL COMMENT '修改人名称',
    `update_time` datetime(3) DEFAULT NULL COMMENT '修改时间',
    `is_del` tinyint(1) DEFAULT 0 COMMENT '是否删除 1:已删除 0:未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4  COMMENT='角色表';