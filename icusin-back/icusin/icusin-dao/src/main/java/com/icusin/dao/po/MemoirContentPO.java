package com.icusin.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * 回忆录内容
 *
 * @author brainy
 * @date 2017-12-20 9:21
 */
@Data
public class MemoirContentPO {

    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte markStatus;

    private String memoirContent;
}