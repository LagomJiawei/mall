CREATE TABLE `sys_dept` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(30) NOT NULL COMMENT '部门名称',
    `pid` bigint NOT NULL COMMENT '上级部门ID',
    `valid_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '有效状态 1:有效 0:无效',
    `create_user_id` bigint NOT NULL COMMENT '创建人ID',
    `create_user_name` varchar(30) NOT NULL COMMENT '创建人名称',
    `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
    `update_user_id` bigint DEFAULT NULL COMMENT '修改人ID',
    `update_user_name` varchar(30)  DEFAULT NULL COMMENT '修改人名称',
    `update_time` datetime(3) DEFAULT NULL COMMENT '修改时间',
    `is_del` tinyint(1) DEFAULT 0 COMMENT '是否删除 1:已删除 0:未删除',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_pid` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';