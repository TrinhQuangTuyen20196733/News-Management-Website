package vn.com.standford.springmvcbasic1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.standford.springmvcbasic1.constant.SystemConstant;
import vn.com.standford.springmvcbasic1.dto.MyUser;
import vn.com.standford.springmvcbasic1.entity.RoleEntity;
import vn.com.standford.springmvcbasic1.entity.UserEntity;
import vn.com.standford.springmvcbasic1.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.Active_Status);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found in System");
        }
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        for (RoleEntity role : userEntity.getRoles()){
            authorityList.add(new SimpleGrantedAuthority(role.getCode()));
        }

        // Put information in Spring Security to remain System
       MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true,
                true, true, authorityList);
        myUser.setFullName(userEntity.getFullName());
        return myUser;
    }
}
