package cn.net.zjw.config;

import cn.net.zjw.annotation.NoLogin;
import cn.net.zjw.util.SpringBeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhangJw
 * @date 2025年12月09日 20:54
 * SpringSecurity配置类
 */
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 重写setApplicationContext方法时，可以获取ApplicationContext实例（Spring容器的上下文，可以通过它获取bean实例）
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        SpringBeanUtil.setApplicationContext(applicationContext);
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // 去除角色名称中包含的前缀 ROLE_
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new BCryptPasswordEncoder();
    }

    /**
     * 定义 Application 的安全策略和过滤器链
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        Set<String> noLoginUrls = new HashSet<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
            HandlerMethod handlerMethod = infoEntry.getValue();
            NoLogin noLogin = handlerMethod.getMethodAnnotation(NoLogin.class);
            if (null != noLogin) {
                // 从Spring容器的上下文中获取使用了@NoLogin注解的接口路径，存入一个集合
                noLoginUrls.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
            }
        }
        // 配置安全策略
        return httpSecurity
                // 禁用 CSRF（跨站请求伪造）保护机制）
                .csrf().disable()
                // 处理异常（启用授权异常处理功能）
                .exceptionHandling()

                .and()
                // 禁用浏览器的 frame options，允许页面嵌入 iframe
                .headers()
                .frameOptions()
                .disable()

                // 设置 Session 策略
                .and()
                // 不创建会话（设置为无状态会话管理策略，不创建或使用 HTTP Session）
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                // 定义放行规则
                .authorizeRequests()
                // 配置了允许直接访问静态资源（允许所有 GET 请求访问静态资源文件（HTML、CSS、JS等）以及 WebSocket 相关路径）
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**"
                ).permitAll()
                // 配置了允许直接访问 Swagger UI 和接口文档，方便调试和查看 API 文档
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                // 允许访问头像资源和 Druid 数据库监控界面
                .antMatchers("/avatar/**").permitAll()
                .antMatchers("/druid/**").permitAll()
                // 放行所有OPTIONS请求（通常用于 CORS 跨域支持）
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 放行无需登录的接口（根据前面收集的 noLoginUrls 集合，动态地将带有 @NoLogin 注解的接口路径加入白名单）
                .antMatchers(noLoginUrls.toArray(new String[0])).permitAll()
                // 除了上述明确放行的路径外，其余所有请求都必须经过身份验证才能访问
                .anyRequest().authenticated()
                .and()
                .build();
    }
}