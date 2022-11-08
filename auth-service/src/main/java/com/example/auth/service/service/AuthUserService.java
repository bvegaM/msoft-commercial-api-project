package com.example.auth.service.service;

import com.example.auth.service.dto.AuthUserDto;
import com.example.auth.service.dto.TokenDto;

public interface AuthUserService {

    AuthUserDto findByUsername(String username);
    AuthUserDto save(AuthUserDto authUserDto);
    TokenDto validate(String token);
}
