package com.icusin.dao.mapper;

import com.icusin.dao.entity.MemoirInfoDO;

public interface MemoirInfoDOMapper {
    int insert(MemoirInfoDO record);

    int insertSelective(MemoirInfoDO record);

    MemoirInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemoirInfoDO record);

    int updateByPrimaryKey(MemoirInfoDO record);
}