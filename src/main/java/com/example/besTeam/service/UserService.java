package com.example.besTeam.service;

import com.example.besTeam.data.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getById(UserDto userDto) throws Exception;
}