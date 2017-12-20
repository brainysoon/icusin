package com.icusin.web.vo;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午9:47
 */
@Data
public class UserInfoVO {

    /* 头像 */
    private String userAvatar;

    /* 昵称 */
    private String userNickname;

    /* 等级 */
    private Byte userLevel;

    /* 积分 */
    private Short userIntegral;
}
