package com.icusin.service.base.impl;

import com.icusin.common.enums.ErrorEnum;
import com.icusin.common.exception.BusinessException;
import com.icusin.dao.entity.UserInfoDO;
import com.icusin.dao.entity.dto.UserInfoDTO;
import com.icusin.service.base.UserInfoService;
import com.icusin.service.bo.UserInfoBO;
import com.icusin.service.constant.UserInfoContant;
import com.icusin.service.params.ActivateQueryParam;
import com.icusin.service.params.RegisterQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午9:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserInfoDTOMapper userInfoDTOMapper;

    @Override
    public Integer saveUserInfoByRegisterQueryParam(RegisterQueryParam registerQueryParam) {

        // 创建新的用户记录
        UserInfoDO userInfoDO = new UserInfoDO();

        // 用户传入的参数
        userInfoDO.setUserAccount(registerQueryParam.getUserAccount());
        userInfoDO.setUserShadow(registerQueryParam.getUserShadow());
        userInfoDO.setUserEmail(registerQueryParam.getUserEmail());

        // 需要默认的参数
        userInfoDO.setGmtCreate(new Date());
        userInfoDO.setGmtModified(userInfoDO.getGmtCreate());
        userInfoDO.setUserAvatar(UserInfoContant.USER_INFO_DEFAULT_AVATAR);
        userInfoDO.setStatus(UserInfoContant.USER_INFO_STAUTS_DISABLE);
        userInfoDO.setUserNickname(UserInfoContant.USER_INFO_DEFAULT_NICKNAME);
        userInfoDO.setUserLevel(UserInfoContant.USER_INFO_DEFAULT_LEVEL);
        userInfoDO.setUserIntegral(UserInfoContant.USER_INFO_DEFAULT_INTEGRAL);

        //保存新的用户
        return userInfoDTOMapper.insert(userInfoDO);
    }

    @Override
    public UserInfoBO getUserInfoByUserName(String userName) {

        // 首先从数据库查找
        UserInfoDTO userInfoDTO = userInfoDTOMapper.getUserInfoByUserName(userName);

        // 如果没有返回空
        if (userInfoDTO == null) return null;

        // 进行数据脱敏
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setCurrentUserName(userName);

        userInfoBO.setId(userInfoDTO.getId());
        userInfoBO.setUserAccount(userInfoDTO.getUserAccount());
        userInfoBO.setUserShadow(userInfoDTO.getUserShadow());
        userInfoBO.setUserEmail(userInfoDTO.getUserEmail());
        userInfoBO.setUserMobile(userInfoDTO.getUserMobile());  // 这里必须进行脱敏
        userInfoBO.setGmtCreate(userInfoDTO.getGmtCreate());
        userInfoBO.setGmtModified(userInfoDTO.getGmtModified());
        userInfoBO.setUserAvatar(userInfoDTO.getUserAvatar());
        userInfoBO.setStatus(userInfoDTO.getStatus());
        userInfoBO.setUserNickname(userInfoDTO.getUserNickname());
        userInfoBO.setUserLevel(userInfoDTO.getUserLevel());
        userInfoBO.setUserIntegral(userInfoDTO.getUserIntegral());

        return userInfoBO;
    }

    @Override
    public void activateUserByActivateQueryParam(ActivateQueryParam activateQueryParam) {

        // 根据标识查询到需要激活用户
        UserInfoDTO userInfoDTO = userInfoDTOMapper.getUserInfoByUserAccount(activateQueryParam
                .getUserAccount());

        // 没有该激活用户
        if (userInfoDTO == null) throw new BusinessException(ErrorEnum.USER_NOT_EXIST);

        // 匹配是否是正确的激活码
        if (!bCryptPasswordEncoder.matches(userInfoDTO.getUserEmail(),
                activateQueryParam.getCode()))
            throw new BusinessException(ErrorEnum.AUTHENTICATION_FAILED);

        // 该用户已经激活
        if (userInfoDTO.getStatus() > 0)
            throw new BusinessException(ErrorEnum.DUPLICATE_OPERATION);

        // 激活流程
        UserInfoDO preareActivateDO = new UserInfoDO();
        preareActivateDO.setId(userInfoDTO.getId());
        preareActivateDO.setStatus(UserInfoContant.USER_INFO_STATUS_ENABLE);
        userInfoDTOMapper.updateByPrimaryKeySelective(preareActivateDO);
    }
}
