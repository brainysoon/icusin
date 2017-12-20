package com.icusin.web.interceptor;

import com.icusin.service.bo.UserInfoBO;
import com.icusin.web.util.CommonUtils;
import com.icusin.web.util.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-10-06 下午5:13
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // 首先拿到登录用户信息 然后处理用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();
        if (userInfoBO != null) {
            CommonUtils.handleUserInfo(request, userInfoBO);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
