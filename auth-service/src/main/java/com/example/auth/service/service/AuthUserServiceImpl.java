package com.example.auth.service.service;

import com.example.auth.service.dto.AuthUserDto;
import com.example.auth.service.dto.TokenDto;
import com.example.auth.service.entity.AuthUser;
import com.example.auth.service.repository.AuthUserRepository;
import com.example.auth.service.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService{

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthUserDto findByUsername(String username) {
        AuthUser authUser = authUserRepository.findByUsername(username).orElse(null);
        return authUser != null ? AuthUserDto.builder().username(authUser.getUsername()).password(authUser.getPassword())
                .build() : null;
    }

    @Override
    public AuthUserDto save(AuthUserDto authUserDto) {
        AuthUser authUser = AuthUser.builder().username(authUserDto.getUsername())
                .password(passwordEncoder.encode(authUserDto.getPassword())).build();
        authUserRepository.save(authUser);
        return authUserDto;
    }

    @Override
    public TokenDto validate(String token) {
        if (jwtProvider.isTokenExpired(token))
            return null;
        String username = jwtProvider.extractUsername(token);
        if(!authUserRepository.findByUsername(username).isPresent())
            return null;
        return TokenDto.builder().jwt(token).build();
    }
}
