package com.icusin.service.base.impl;

import com.icusin.dao.entity.MemoirContentDO;
import com.icusin.dao.entity.MemoirInfoDO;
import com.icusin.service.base.MemoirInfoService;
import com.icusin.service.bo.MemoirInfoBO;
import com.icusin.service.constant.MemoirContentConstant;
import com.icusin.service.constant.MemoirInfoConstant;
import com.icusin.service.params.AddMemoirParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午12:01
 */
@Service
public class MemoirInfoServiceImpl implements MemoirInfoService {

    @Autowired
    private MemoirInfoDTOMapper memoirInfoDTOMapper;

    @Autowired
    private MemoirContentDTOMapper memoirContentDTOMapper;

    @Override
    @Transactional
    public Integer saveMemoirByAddMemoirParam(AddMemoirParam addMemoirParam) {

        // 现在时间
        Date now = new Date();

        // 首先添加内容
        MemoirContentDO memoirContentDO = new MemoirContentDO();
        memoirContentDO.setMemoirContent(addMemoirParam.getContent());
        memoirContentDO.setGmtCreate(now);
        memoirContentDO.setGmtModified(memoirContentDO.getGmtCreate());
        memoirContentDO.setStatus(MemoirContentConstant.MEMOIR_CONTENT_STATUS_ENABLE);
        memoirContentDTOMapper.insertSelective(memoirContentDO);

        // 然后添加自传
        MemoirInfoDO memoirInfoDO = addMemoirParam;
        memoirInfoDO.setContentRefId(memoirContentDO.getId());
        memoirInfoDO.setGmtCreate(now);
        memoirInfoDO.setGmtModified(memoirInfoDO.getGmtCreate());
        memoirInfoDO.setStatus(MemoirInfoConstant.MEMOIR_INFO_STATUS_ENABLE);
        return memoirInfoDTOMapper.insertSelective(memoirInfoDO);
    }

    @Override
    public MemoirInfoBO listMemoirByUserInfoId(Integer userInfoId) {

        // 查询所有的自传
        MemoirInfoBO memoirInfoBO = new MemoirInfoBO();
        memoirInfoBO.setBases(memoirInfoDTOMapper.listMemoirInfoByUserInfoId(userInfoId));

        return memoirInfoBO;
    }

    @Override
    public MemoirInfoBO getMemoirDetailById(Integer id) {

        // 返回文章详细信息
        MemoirInfoBO memoirInfoBO = new MemoirInfoBO();
        memoirInfoBO.setBase(memoirInfoDTOMapper.getMemoirDetailById(id));
        return memoirInfoBO;
    }
}
