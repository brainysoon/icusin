package com.icusin.service.params;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午9:05
 */
@Data
public class RegisterQueryParam {

    /*账户名*/
    private String userAccount;

    /*邮箱*/
    private String userEmail;

    /*密码*/
    private String userShadow;
}
