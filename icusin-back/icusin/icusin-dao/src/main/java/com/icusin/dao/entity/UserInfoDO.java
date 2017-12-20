package com.icusin.dao.entity;

import java.util.Date;

public class UserInfoDO {
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

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserShadow() {
        return userShadow;
    }

    public void setUserShadow(String userShadow) {
        this.userShadow = userShadow == null ? null : userShadow.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Byte getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    public Short getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Short userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}