package cn.net.zjw.entity.user;

import cn.net.zjw.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhangJw
 * @date 2025年12月06日 15:01
 * 用户实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity extends BaseEntity {
    /**
     * 用户名称
     */
    private String userName;
}