package com.commercial.api.account.service;

import com.commercial.api.account.dto.UserDTO;
import com.commercial.api.account.dto.mapper.UserMapper;
import com.commercial.api.account.model.User;
import com.commercial.api.account.repository.UserRepository;
import com.commercial.api.account.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        return this.userMapper.toUserDtos(this.userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.map(value -> this.userMapper.toUserDto(value)).orElse(null);
    }

    @Override
    public UserDTO findByUsername(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        return user.map(value -> this.userMapper.toUserDto(value)).orElse(null);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = User.builder().username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword())).build();
        return this.userMapper.toUserDto(this.userRepository.save(user));
    }

}
