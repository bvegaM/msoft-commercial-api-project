package com.example.auth.service.service;

import com.example.auth.service.entity.AuthUser;
import com.example.auth.service.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> user = this.authUserRepository.findByUsername(username);
        return user.map(value -> new User(value.getUsername(),value.getPassword(),new ArrayList<>())).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
    }
}
