use mall;

CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_name` varchar(30)  DEFAULT NULL COMMENT '用户名',
    `create_user_id` bigint NOT NULL COMMENT '创建人ID',
    `create_user_name` varchar(30) NOT NULL COMMENT '创建人名称',
    `create_time` datetime(3) NOT NULL COMMENT '创建日期',
    `update_user_id` bigint DEFAULT NULL COMMENT '修改人ID',
    `update_user_name` varchar(30)  DEFAULT NULL COMMENT '修改人名称',
    `update_time` datetime(3) DEFAULT NULL COMMENT '修改日期',
    `is_del` tinyint(1) DEFAULT 0 COMMENT '是否删除 1: 已删除, 0: 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表'