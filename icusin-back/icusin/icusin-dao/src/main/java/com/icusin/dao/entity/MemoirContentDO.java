package com.icusin.dao.entity;

import java.util.Date;

public class MemoirContentDO {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    private String memoirContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMemoirContent() {
        return memoirContent;
    }

    public void setMemoirContent(String memoirContent) {
        this.memoirContent = memoirContent == null ? null : memoirContent.trim();
    }
}