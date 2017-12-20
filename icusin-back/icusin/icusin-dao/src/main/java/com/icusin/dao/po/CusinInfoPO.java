package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * 表亲信息
 *
 * @author brainy
 * @date 2017-12-20 9:23
 */
@Data
public class CusinInfoPO {

    private Integer id;

    private Integer refUserInfoId;

    private String cusinName;

    private Byte cusinSex;

    private Date cusinBirthday;

    private String cusinCareer;

    private String cusinPhoto;

    private String cusinAdd;

    private Integer refAreaInfoId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte cusinPerms;

    private Byte markStatus;
}