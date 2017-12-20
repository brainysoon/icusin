package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author brainy
 * @date 2017-12-20 16:36
 */
@Data
public class CusinRelPO {

    private Integer id;

    private Integer refUserInfoId;

    private String relName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}