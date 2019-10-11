package com.cmkj.mall.common.exception;

import com.cmkj.mall.common.api.IErrorCode;

/**
 * @author swallowff
 * @create 2019/10/11
 */
public class CheckedServiceException extends Exception {
    public CheckedServiceException() {
    }

    public CheckedServiceException(String message) {
        super(message);
    }

    public CheckedServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedServiceException(Throwable cause) {
        super(cause);
    }

    public CheckedServiceException(IErrorCode errorCode){
        super(errorCode.getCode() + ":" + errorCode.getMessage());
    }
}
