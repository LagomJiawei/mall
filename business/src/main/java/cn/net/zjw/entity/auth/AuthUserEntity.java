package cn.net.zjw.entity.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ZhangJw
 * @date 2025年12月10日 19:44
 * 用户录入信息实体类
 */
@ApiModel("权限用户实体")
@Data
public class AuthUserEntity {

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    @ApiModelProperty("用户名称")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    @NotBlank
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String code;
}