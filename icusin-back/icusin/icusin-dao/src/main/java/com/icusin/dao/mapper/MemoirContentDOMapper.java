package com.icusin.dao.mapper;

import com.icusin.dao.entity.MemoirContentDO;

public interface MemoirContentDOMapper {
    int insert(MemoirContentDO record);

    int insertSelective(MemoirContentDO record);

    MemoirContentDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemoirContentDO record);

    int updateByPrimaryKeyWithBLOBs(MemoirContentDO record);

    int updateByPrimaryKey(MemoirContentDO record);
}