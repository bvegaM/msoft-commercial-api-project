package com.commercial.api.account.service;

import com.commercial.api.account.repository.UserRepository;
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
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.commercial.api.account.model.User> user = this.userRepository.findByUsername(username);
        return user.map(value -> new User(value.getUsername(),value.getPassword(),new ArrayList<>())).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
    }
}
