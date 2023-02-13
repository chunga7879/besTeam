package com.example.besTeam.controller;

import com.example.besTeam.data.dto.UserDto;
import com.example.besTeam.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public UserDto create(@RequestBody @Valid UserDto userDto) {
        return userService.createUser(userDto);
    }

}
