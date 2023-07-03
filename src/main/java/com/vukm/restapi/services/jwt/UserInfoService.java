package com.vukm.restapi.services.jwt;

import com.vukm.restapi.entities.UserEntity;
import com.vukm.restapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author kieuvu
 * Created on 02/07/2023.
 */
@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = this.userService.getUserByEmail(email);

        if (user == null) throw new UsernameNotFoundException("Unauthorized");

        return User.builder()
                   .username(user.getEmail())
                   .password(user.getPassword())
                   .roles("NORMAL_USER")
                   .build();
    }
}