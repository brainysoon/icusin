package com.icusin.dao.entity;

import java.util.Date;

public class AreaInfoDO {
    private Integer id;

    private String areaName;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte status;

    private Integer parRefId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
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

    public Integer getParRefId() {
        return parRefId;
    }

    public void setParRefId(Integer parRefId) {
        this.parRefId = parRefId;
    }
}