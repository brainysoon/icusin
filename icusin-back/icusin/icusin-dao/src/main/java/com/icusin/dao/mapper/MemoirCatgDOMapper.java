package com.icusin.dao.mapper;

import com.icusin.dao.entity.MemoirCatgDO;

public interface MemoirCatgDOMapper {
    int insert(MemoirCatgDO record);

    int insertSelective(MemoirCatgDO record);

    MemoirCatgDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemoirCatgDO record);

    int updateByPrimaryKey(MemoirCatgDO record);
}