package com.icusin.service.security;

import com.icusin.service.base.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午5:15
 */
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 通过用户名获取用户信息(可能是用户名,电话,邮箱)
        UserDetails userDetails = userInfoService.getUserInfoByUserName(username);

        // 不存在该用户
        if (userDetails == null) {

            throw new UsernameNotFoundException("该用户不存在！");
        }

        // 封装信息

        return userDetails;
    }
}
