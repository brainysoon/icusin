package com.icusin.service.base;

import com.icusin.service.bo.MemoirContentBO;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午4:55
 */
public interface MemoirContentService {

    /**
     * 根据id 查找文章
     *
     * @param id 固定文章的id
     * @return 文章
     */
    MemoirContentBO getMemoirContentById(Integer id);
}
