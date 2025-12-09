package cn.net.zjw.handler;

import cn.net.zjw.entity.ApiResult;
import cn.net.zjw.entity.ApiResultUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhangJw
 * @date 2025年12月09日 19:39
 * 全局API请求正常处理类：将所有非 ApiResult 类型的返回值自动封装成标准的API请求成功的响应格式
 *
 * 1.@ControllerAdvice: 这是一个控制器增强类，可以全局处理控制器层的异常和响应
 * 2.实现响应体增强接口，用于在响应数据返回给客户端之前进行统一处理
 * 3.supports方法：判断当前处理器是否应该应用到特定的控制器方法上
 * 3.1 入参：
 * MethodParameter returnType: 控制器方法的返回值类型
 * Class<? extends HttpMessageConverter<?>> converterType: HTTP消息转换器类型
 * 3.2 返参：
 * boolean: 返回true表示应用此处理器，false表示不应用
 * 4.beforeBodyWrite方法：在响应数据返回给客户端之前进行统一处理。判断响应体 body 是否已经是 ApiResult 类型，如果是则直接返回原始响应体；如果不是则将原始响应体封装成统一的API响应格
 * 4.1 入参：
 * Object body: 控制器方法返回的原始响应体数据
 * MethodParameter returnType: 控制器方法的返回值类型
 * MediaType selectedContentType: 响应内容类型
 * Class<? extends HttpMessageConverter<?>> selectedConverterType: 选定的HTTP消息转换器类型
 * ServerHttpRequest request: 服务器端HTTP请求对象
 * ServerHttpResponse response: 服务器端HTTP响应对象
 */
@ControllerAdvice
public class GlobalApiResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String requestURI = request.getRequestURI();
        return matchUrl(requestURI);
    }

    private boolean matchUrl(String uri) {
        if (StringUtils.isBlank(uri)) {
            return false;
        }
        return uri.contains("/v1");
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResult) {
            return (ApiResult) body;
        }
        return ApiResultUtil.success(body);
    }
}