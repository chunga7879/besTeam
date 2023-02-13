package com.example.besTeamAt.service.impl;

import com.example.besTeamAt.data.dao.UserDAO;
import com.example.besTeamAt.data.dto.UserDto;
import com.example.besTeamAt.data.entity.User;
import com.example.besTeamAt.service.UserService;
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
}
