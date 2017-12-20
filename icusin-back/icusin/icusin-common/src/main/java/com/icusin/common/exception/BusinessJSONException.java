package com.icusin.common.exception;

import com.icusin.common.enums.ErrorEnum;
import lombok.Getter;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午5:13
 */
public class BusinessJSONException extends RuntimeException {


    @Getter
    private String code;

    public BusinessJSONException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public BusinessJSONException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    public BusinessJSONException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
