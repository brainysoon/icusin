package com.icusin.service.params;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午2:26
 */
@Data
public class ActivateQueryParam {

    /*用户标识*/
    private String userAccount;

    /*加密过后的邮件地址*/
    private String code;
}
