package com.zfq.rbac.service;

import com.zfq.rbac.mapper.AccessMapper;
import com.zfq.rbac.mapper.UserMapper;
import com.zfq.rbac.model.Access;
import com.zfq.rbac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： zzzhaofq
 * @Data ： 2018/10/11 21:52
 * @Functions ：通过username获取user
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccessMapper accessMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if (null != username) {
            List<Access> accesses = accessMapper.selectByUsername(username);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Access access :
                    accesses) {
                if (access != null && access.getName() != null) {
                    GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(access.getUrl(), access.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
        return null;
    }
}
