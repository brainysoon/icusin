package com.icusin.service.bo;

import com.icusin.dao.entity.dto.UserInfoDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * copyright icusin.com
 * 用户信息业务逻辑对象 实现了UserDetails 接口 可供SpringSecurityContext存储
 *
 * @author brainysoon
 * @create 2017-09-21 上午11:42
 */
@Data
public class UserInfoBO extends UserInfoDTO implements UserDetails {

    /*当前登录用的用户名(可能是用户名,手机号码,邮箱)*/
    private String currentUserName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //暂时没有考虑权限问题,所有的用户都有角色 ROLE_USER
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {

        //返回拿到的用户密码(已经加过密的)
        return this.getUserShadow();
    }

    @Override
    public String getUsername() {

        //返回登录用的用户名
        return this.getCurrentUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        //账户是否可用 根据状态判断 0.无效 1有效
        return this.getStatus() > 0;
    }
}
