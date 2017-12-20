package com.icusin.service.params;

import com.icusin.dao.entity.MemoirInfoDO;
import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 上午11:57
 */
@Data
public class AddMemoirParam extends MemoirInfoDO {

    /* 添加的自传内容 */
    private String content;
}
