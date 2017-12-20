package com.icusin.web.vo;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午7:26
 */
@Data
public class ResendEmailVO {

    /* 对应的账户 */
    private String userAccount;

    /* 对应加过密的邮箱 */
    private String code;

    /* 邮件地址 */
    private String userEmail;
}
