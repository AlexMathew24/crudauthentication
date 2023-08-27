package com.alex.jwt.backendtest.mappers;

import com.alex.jwt.backendtest.dto.UserDto;

import com.alex.jwt.backendtest.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
