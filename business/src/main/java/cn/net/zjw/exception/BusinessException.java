package cn.net.zjw.exception;

import lombok.Data;

/**
 * @author ZhangJw
 * @date 2025年12月09日 19:20
 * 业务异常类
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2255873606069423584L;

    /**
     * 异常码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;
    public BusinessException() {
        super();
    }
}