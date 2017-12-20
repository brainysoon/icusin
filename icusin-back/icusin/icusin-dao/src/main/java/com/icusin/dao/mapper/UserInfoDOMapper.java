package com.icusin.dao.mapper;

import com.icusin.dao.entity.UserInfoDO;

public interface UserInfoDOMapper {
    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    UserInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);
}