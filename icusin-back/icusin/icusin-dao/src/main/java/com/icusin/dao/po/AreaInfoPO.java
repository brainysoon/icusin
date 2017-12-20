package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * 区域信息
 *
 * @author brainy
 * @date 2017-12-20 16:27
 */
@Data
public class AreaInfoPO {

    private Integer id;

    private Integer refParentId;

    private String areaName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;
}