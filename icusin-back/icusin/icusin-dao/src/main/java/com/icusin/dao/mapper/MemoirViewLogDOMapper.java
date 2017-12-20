package com.icusin.dao.mapper;

import com.icusin.dao.entity.MemoirViewLogDO;

public interface MemoirViewLogDOMapper {
    int insert(MemoirViewLogDO record);

    int insertSelective(MemoirViewLogDO record);

    MemoirViewLogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemoirViewLogDO record);

    int updateByPrimaryKey(MemoirViewLogDO record);
}