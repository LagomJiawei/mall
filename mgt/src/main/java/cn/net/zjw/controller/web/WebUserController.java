package cn.net.zjw.controller.web;

import cn.net.zjw.annotation.NoLogin;
import cn.net.zjw.entity.auth.AuthUserEntity;
import cn.net.zjw.entity.auth.TokenEntity;
import cn.net.zjw.service.sys.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ZhangJw
 * @date 2025年12月10日 18:33
 * 给前端用的用户接口
 */
@Api(tags = "web用户操作", description = "web用户接口")
@RestController
@RequestMapping("/v1/web/user")
@Validated
public class WebUserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * 生成JWT令牌
     * @param authUserEntity 用户录入信息
     * @return 影响行数
     */
    @NoLogin
    @ApiOperation(notes = "用户登录", value = "用户登录")
    @PostMapping("/login")
    public TokenEntity login(@Valid @RequestBody AuthUserEntity authUserEntity) {
        return userService.login(authUserEntity);
    }

//    /**
//     * 用户退出登录
//     *
//     * @param request 请求
//     * @return 影响行数
//     */
//    @NoLogin
//    @ApiOperation(notes = "用户退出登录", value = "用户退出登录")
//    @PostMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        userService.logout(request);
//    }
}