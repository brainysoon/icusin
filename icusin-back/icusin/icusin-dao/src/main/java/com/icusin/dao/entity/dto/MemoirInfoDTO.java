package com.icusin.dao.entity.dto;

import com.icusin.dao.entity.MemoirInfoDO;
import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午8:37
 */
@Data
public class MemoirInfoDTO extends MemoirInfoDO {

    /*　文章内容　*/
    private String memoirContent;

    /* 表亲名 */
    private String cusinName;
}
