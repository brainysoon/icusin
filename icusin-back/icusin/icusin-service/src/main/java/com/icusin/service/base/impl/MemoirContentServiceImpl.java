package com.icusin.service.base.impl;

import com.icusin.dao.mapper.dto.MemoirContentDTOMapper;
import com.icusin.service.base.MemoirContentService;
import com.icusin.service.bo.MemoirContentBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午4:55
 */
@Service
public class MemoirContentServiceImpl implements MemoirContentService {

    @Autowired
    private MemoirContentDTOMapper memoirContentDTOMapper;

    @Override
    public MemoirContentBO getMemoirContentById(Integer id) {

        // 拿取文章内容
        MemoirContentBO memoirContentBO = new MemoirContentBO();
        memoirContentBO.setBase(memoirContentDTOMapper.getMemoirContentById(id));

        return memoirContentBO;
    }
}
