package com.icusin.dao.mapper;

import com.icusin.dao.entity.CusinInfoDO;

public interface CusinInfoDOMapper {
    int insert(CusinInfoDO record);

    int insertSelective(CusinInfoDO record);

    CusinInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusinInfoDO record);

    int updateByPrimaryKey(CusinInfoDO record);
}