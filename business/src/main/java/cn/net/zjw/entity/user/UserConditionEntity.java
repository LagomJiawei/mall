package cn.net.zjw.entity.user;

import cn.net.zjw.entity.RequestPageEntity;
import lombok.Data;

/**
 * @author ZhangJw
 * @date 2025年12月06日 15:58
 * 用户查询条件实体
 */
@Data
public class UserConditionEntity extends RequestPageEntity {
    /**
     * 系统ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;
}