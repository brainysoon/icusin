package com.icusin.dao.entity;

import java.util.Date;

public class CusinViewLogDO {
    private Integer id;

    private Integer userRefId;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte status;

    private Integer cusinRefId;

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

    public Integer getCusinRefId() {
        return cusinRefId;
    }

    public void setCusinRefId(Integer cusinRefId) {
        this.cusinRefId = cusinRefId;
    }
}