package cn.net.zjw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author ZhangJw
 * @date 2025年12月10日 20:41
 */
@Configuration
public class HandlerMappingConfig {

    @Bean
    @Primary  // 标记为优先注入的Bean
    public HandlerMapping primaryHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }
}