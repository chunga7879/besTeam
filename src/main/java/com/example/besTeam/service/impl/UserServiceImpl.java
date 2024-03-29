package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.UserDAO;
import com.example.besTeam.data.dto.UserDto;
import com.example.besTeam.data.entity.User;
import com.example.besTeam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
//    private final BCryptPasswordEncoder passwordEncoder;


//    @Autowired
//    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
//        this.userDAO = userDAO;
//        this.passwordEncoder = passwordEncoder;
//    }
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDAO.save(User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword()).build());
//        User user = userDAO.saveUser(User.builder().name(userDto.getName()).email(userDto.getEmail()).password(passwordEncoder.encode(userDto.getPassword()))
//                .build());

        return user.toDto();
    }

    @Override
    public UserDto getById(UserDto userDto) throws Exception {
        return userDAO.getById(userDto.getId()).toDto();
    }
}
