package com.icusin.dao.mapper;

import com.icusin.dao.entity.MemoirCmtDO;

public interface MemoirCmtDOMapper {
    int insert(MemoirCmtDO record);

    int insertSelective(MemoirCmtDO record);

    MemoirCmtDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemoirCmtDO record);

    int updateByPrimaryKey(MemoirCmtDO record);
}