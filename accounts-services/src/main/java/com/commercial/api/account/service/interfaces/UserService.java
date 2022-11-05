package com.commercial.api.account.service.interfaces;

import com.commercial.api.account.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //GET
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO findByUsername(String username);

    //POST
    UserDTO save(UserDTO userRequestDTO);
}
