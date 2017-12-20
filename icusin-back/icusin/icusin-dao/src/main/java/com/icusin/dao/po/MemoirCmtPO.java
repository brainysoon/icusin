package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author brainy
 * @date 2017-12-20 19:13
 */
@Data
public class MemoirCmtPO {

    private Integer id;

    private String cmtContent;

    private Integer refUserInfoId;

    private Integer refMemoirInfoId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}