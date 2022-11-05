package com.commercial.api.account.dto.mapper;

import com.commercial.api.account.dto.UserDTO;
import com.commercial.api.account.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    UserDTO toUserDto(User user);
    List<UserDTO> toUserDtos(List<User> users);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    User toUser(UserDTO userDTO);
}
