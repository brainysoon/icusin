package com.icusin.dao.util;

import com.icusin.dao.po.UserInfoPO;

import java.util.Date;

/**
 * 生成用于测试的对象
 *
 * @author brainy
 * @date 2017-12-20 20:23
 */
public class MockUtils {

    /**
     * 生成一个用户信息
     *
     * @return 用户信息对象
     */
    public static UserInfoPO mockUserInfo() {

        UserInfoPO userInfoPO = new UserInfoPO();

        userInfoPO.setUserAccount("barinyTest");
        userInfoPO.setUserShadow("00100");
        userInfoPO.setUserEmail("email@sence.com");
        userInfoPO.setUserMobile("13166956701");
        userInfoPO.setUserNickname("我是");
        userInfoPO.setUserAvatar("888888");
        userInfoPO.setUserLevel((byte) 0);
        userInfoPO.setUserIntegral((short) 11);
        userInfoPO.setGmtModified(new Date());
        userInfoPO.setGmtCreate(new Date());
        userInfoPO.setMarkStatus((byte) 1);

        return userInfoPO;
    }
}
