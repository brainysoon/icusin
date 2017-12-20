package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author brainy
 * @date 2017-12-20 19:12
 */
@Data
public class MemoirCatgPO {
    private Integer id;

    private String catgName;

    private Integer refUserInfoId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}