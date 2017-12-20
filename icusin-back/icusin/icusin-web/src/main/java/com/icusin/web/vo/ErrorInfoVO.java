package com.icusin.web.vo;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午7:02
 */
@Data
public class ErrorInfoVO {

    /* 错误状态码 */
    private String code;

    /* 错误信息 */
    private String message;

    /* 挽回错误链接 */
    private String recoverLink;

    /* 挽回错误文字 */
    private String recoverTitle;
}
