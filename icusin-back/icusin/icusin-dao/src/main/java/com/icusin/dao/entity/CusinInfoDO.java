package com.icusin.dao.entity;

import java.util.Date;

public class CusinInfoDO {
    private Integer id;

    private Integer userRefId;

    private String cusinName;

    private Byte cusinSex;

    private Date cusinBirthday;

    private String cusinCareer;

    private String cusinPhoto;

    private String cusinAdd;

    private Integer areaRefId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte cusinPerms;

    private Byte status;

    private Integer relRefId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserRefId() {
        return userRefId;
    }

    public void setUserRefId(Integer userRefId) {
        this.userRefId = userRefId;
    }

    public String getCusinName() {
        return cusinName;
    }

    public void setCusinName(String cusinName) {
        this.cusinName = cusinName == null ? null : cusinName.trim();
    }

    public Byte getCusinSex() {
        return cusinSex;
    }

    public void setCusinSex(Byte cusinSex) {
        this.cusinSex = cusinSex;
    }

    public Date getCusinBirthday() {
        return cusinBirthday;
    }

    public void setCusinBirthday(Date cusinBirthday) {
        this.cusinBirthday = cusinBirthday;
    }

    public String getCusinCareer() {
        return cusinCareer;
    }

    public void setCusinCareer(String cusinCareer) {
        this.cusinCareer = cusinCareer == null ? null : cusinCareer.trim();
    }

    public String getCusinPhoto() {
        return cusinPhoto;
    }

    public void setCusinPhoto(String cusinPhoto) {
        this.cusinPhoto = cusinPhoto == null ? null : cusinPhoto.trim();
    }

    public String getCusinAdd() {
        return cusinAdd;
    }

    public void setCusinAdd(String cusinAdd) {
        this.cusinAdd = cusinAdd == null ? null : cusinAdd.trim();
    }

    public Integer getAreaRefId() {
        return areaRefId;
    }

    public void setAreaRefId(Integer areaRefId) {
        this.areaRefId = areaRefId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getCusinPerms() {
        return cusinPerms;
    }

    public void setCusinPerms(Byte cusinPerms) {
        this.cusinPerms = cusinPerms;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getRelRefId() {
        return relRefId;
    }

    public void setRelRefId(Integer relRefId) {
        this.relRefId = relRefId;
    }
}