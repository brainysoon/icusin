package com.icusin.dao.mapper.dto;

import com.icusin.dao.entity.dto.UserInfoDTO;
import com.icusin.dao.mapper.UserInfoDOMapper;
import org.apache.ibatis.annotations.Param;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午8:47
 */
public interface UserInfoDTOMapper extends UserInfoDOMapper {

    /**
     * 通过用户名查找用户
     *
     * @param userName 可能是(用户名,手机号,邮箱)
     * @return 用户信息
     */
    UserInfoDTO getUserInfoByUserName(@Param("userName") String userName);

    UserInfoDTO getUserInfoByUserAccount(@Param("userAccount") String userAccount);
}
