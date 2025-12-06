package cn.net.zjw.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangJw
 * @date 2025年12月06日 22:22
 * 应用启动时，加载一下配置
 */
@MapperScan(basePackages = "cn.net.zjw.mapper")
@Configuration
public class ApplicationConfig {
}