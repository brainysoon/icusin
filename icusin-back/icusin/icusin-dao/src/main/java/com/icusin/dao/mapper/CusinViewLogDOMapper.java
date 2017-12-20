package com.icusin.dao.mapper;

import com.icusin.dao.entity.CusinViewLogDO;

public interface CusinViewLogDOMapper {
    int insert(CusinViewLogDO record);

    int insertSelective(CusinViewLogDO record);

    CusinViewLogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusinViewLogDO record);

    int updateByPrimaryKey(CusinViewLogDO record);
}