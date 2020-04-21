package com.brokencodes.vd.security;

import com.brokencodes.vd.beans.users.Role;
import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VdUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = userService.findByEmailId(email);
        String[] authorities = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList())
                .toArray(new String[user.getRoles().size()]);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .accountExpired(false)
                .accountLocked(!user.isEnabled())
                .disabled(!user.isEnabled())
                .credentialsExpired(false)
                .passwordEncoder(passwordEncoder::encode)
                .roles(authorities)
                .authorities(authorities)
                .build();
    }

}
