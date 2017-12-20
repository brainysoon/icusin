package com.icusin.service.base;

import com.icusin.service.bo.UserInfoBO;
import com.icusin.service.params.ActivateQueryParam;
import com.icusin.service.params.RegisterQueryParam;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午9:11
 */
public interface UserInfoService {

    /**
     * @param registerQueryParam 注册参数封装
     * @return 注册成功的id号
     */
    Integer saveUserInfoByRegisterQueryParam(RegisterQueryParam registerQueryParam);

    /**
     * 根据登录的用户名查找用户信息
     *
     * @param userName 登录的用户名 可能是(用户名,手机号码,邮箱)
     * @return 用户信息
     */
    UserInfoBO getUserInfoByUserName(String userName);

    void activateUserByActivateQueryParam(ActivateQueryParam activateQueryParam);
}
