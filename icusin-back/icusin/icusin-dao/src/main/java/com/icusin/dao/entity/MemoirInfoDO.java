package com.icusin.dao.entity;

import java.util.Date;

public class MemoirInfoDO {
    private Integer id;

    private Integer cusinRefId;

    private String memoirTitle;

    private String memoirDigest;

    private Integer catgRefId;

    private Integer contentRefId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusinRefId() {
        return cusinRefId;
    }

    public void setCusinRefId(Integer cusinRefId) {
        this.cusinRefId = cusinRefId;
    }

    public String getMemoirTitle() {
        return memoirTitle;
    }

    public void setMemoirTitle(String memoirTitle) {
        this.memoirTitle = memoirTitle == null ? null : memoirTitle.trim();
    }

    public String getMemoirDigest() {
        return memoirDigest;
    }

    public void setMemoirDigest(String memoirDigest) {
        this.memoirDigest = memoirDigest == null ? null : memoirDigest.trim();
    }

    public Integer getCatgRefId() {
        return catgRefId;
    }

    public void setCatgRefId(Integer catgRefId) {
        this.catgRefId = catgRefId;
    }

    public Integer getContentRefId() {
        return contentRefId;
    }

    public void setContentRefId(Integer contentRefId) {
        this.contentRefId = contentRefId;
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
}