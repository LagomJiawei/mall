package cn.net.zjw.handler;

import cn.hutool.http.HttpStatus;
import cn.net.zjw.entity.ApiResult;
import cn.net.zjw.entity.ApiResultUtil;
import cn.net.zjw.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZhangJw
 * @date 2025年12月09日 19:27
 * 全局API请求异常处理类：处理的异常是最底层的Throwable
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一处理异常
     *
     * @param e 异常
     * @return API请求的响应实体
     */
    @ExceptionHandler(Throwable.class)
    private ApiResult handleException(Throwable e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            log.error("当前请求出现业务异常：", e);
            return ApiResultUtil.error(businessException.getCode(), businessException.getMessage());
        }
        log.error("当前请求出现系统异常：", e);
        return ApiResultUtil.error(HttpStatus.HTTP_INTERNAL_ERROR, "服务器内部错误");
    }
}