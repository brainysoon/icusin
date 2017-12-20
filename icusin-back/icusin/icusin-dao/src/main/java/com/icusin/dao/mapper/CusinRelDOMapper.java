package com.icusin.dao.mapper;

import com.icusin.dao.entity.CusinRelDO;

public interface CusinRelDOMapper {
    int insert(CusinRelDO record);

    int insertSelective(CusinRelDO record);

    CusinRelDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusinRelDO record);

    int updateByPrimaryKey(CusinRelDO record);
}