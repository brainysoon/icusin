package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * 回忆录信息
 *
 * @author brainy
 * @date 2017-12-20 9:20
 */
@Data
public class MemoirInfoPO {

    private Integer id;

    private Integer refCusinInfoId;

    private Integer refUserInfoId;

    private String memoirTitle;

    private String memoirDigest;

    private Integer refMemoirCatgId;

    private Integer refMemoirContentId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}