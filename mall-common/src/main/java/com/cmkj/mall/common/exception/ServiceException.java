package com.cmkj.mall.common.exception;

import com.cmkj.mall.common.api.IErrorCode;

/**
 * @author swallowff
 * @create 2019/10/11
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(IErrorCode errorCode){
        super(errorCode.getCode() + ":" + errorCode.getMessage());
    }
}
