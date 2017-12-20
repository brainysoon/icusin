package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author brainy
 * @date 2017-12-20 19:51
 */
@Data
public class UserLogPO {

    private Integer id;

    private Integer refUserInfoId;

    private Integer refId;

    private String logContent;

    private Byte logType;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}