package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 *
 * @author brainy
 * @date 2017-12-20 9:19
 */
@Data
public class UserInfoPO {

    private Integer id;

    private String userAccount;

    private String userShadow;

    private String userEmail;

    private String userMobile;

    private String userNickname;

    private String userAvatar;

    private Byte userLevel;

    private Short userIntegral;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte markStatus;
}