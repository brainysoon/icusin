package com.icusin.dao.mapper;

import com.icusin.dao.entity.AreaInfoDO;

public interface AreaInfoDOMapper {
    int insert(AreaInfoDO record);

    int insertSelective(AreaInfoDO record);

    AreaInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreaInfoDO record);

    int updateByPrimaryKey(AreaInfoDO record);
}