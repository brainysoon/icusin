package com.icusin.web.util;

import com.icusin.service.bo.UserInfoBO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午4:16
 */
public class SecurityUtils {

    /**
     * 获取当前登录用户对应的对象
     *
     * @return 返回当前登录用户对象
     */
    public static UserInfoBO getUserInfoFromSecurityContext() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserInfoBO) {

            return (UserInfoBO) principal;
        } else {

            return null;
        }
    }
}
