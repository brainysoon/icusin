package com.icusin.web.util;

import com.icusin.service.bo.UserInfoBO;
import com.icusin.web.constant.AttrConstant;
import com.icusin.web.vo.MenuInfoVO;
import com.icusin.web.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 上午7:52
 */
public class CommonUtils {

    /**
     * 处理用户信息
     *
     * @param request    请求,需要将用户信息放到这里面
     * @param userInfoBO 登录用户的信息
     */
    public static void handleUserInfo(HttpServletRequest request, UserInfoBO userInfoBO) {

        // 视图对象
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserNickname(userInfoBO.getUserNickname());
        userInfoVO.setUserAvatar(userInfoBO.getUserAvatar());
        userInfoVO.setUserLevel(userInfoBO.getUserLevel());
        userInfoVO.setUserIntegral(userInfoBO.getUserIntegral());

        request.setAttribute(AttrConstant.ICUSIN_ATTR_USER_PROFILE, userInfoVO);
    }

    /**
     * 处理菜单信息
     *
     * @param request    请求,需要将菜单信息放到里面
     * @param menuInfoVO 菜单信息
     */
    public static void handleMenuInfo(HttpServletRequest request, MenuInfoVO menuInfoVO) {

        request.setAttribute(AttrConstant.ICUSIN_ATTR_MENU, menuInfoVO);
    }
}
