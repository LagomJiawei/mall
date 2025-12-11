package cn.net.zjw.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhangJw
 * @date 2025年12月10日 19:42
 * JWT令牌实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenEntity {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 令牌
     */
    private String token;
}