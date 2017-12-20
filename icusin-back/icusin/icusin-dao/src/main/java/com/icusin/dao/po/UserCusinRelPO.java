package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author brainy
 * @date 2017-12-20 19:15
 */
@Data
public class UserCusinRelPO {

    private Integer id;

    private Integer refUserInfoId;

    private Integer refCusinInfoId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}