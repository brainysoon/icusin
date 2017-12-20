package com.icusin.dao.entity;

import java.util.Date;

public class MemoirViewLogDO {
    private Integer id;

    private Integer userRefId;

    private Integer memoirRefId;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte status;

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

    public Integer getMemoirRefId() {
        return memoirRefId;
    }

    public void setMemoirRefId(Integer memoirRefId) {
        this.memoirRefId = memoirRefId;
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