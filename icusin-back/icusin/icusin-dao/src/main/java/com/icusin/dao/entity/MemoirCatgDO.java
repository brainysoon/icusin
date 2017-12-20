package com.icusin.dao.entity;

import java.util.Date;

public class MemoirCatgDO {
    private Integer id;

    private String catgName;

    private Integer userRefId;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
    }

    public Integer getUserRefId() {
        return userRefId;
    }

    public void setUserRefId(Integer userRefId) {
        this.userRefId = userRefId;
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