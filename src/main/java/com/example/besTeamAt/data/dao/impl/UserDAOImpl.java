package com.example.besTeamAt.data.dao.impl;

import com.example.besTeamAt.data.dao.UserDAO;
import com.example.besTeamAt.data.entity.User;
import com.example.besTeamAt.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDAO {

    private UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User getById(Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("user id"));

        return user;
    }

    public User getByEmail(String email){
        User user = userRepository.findByEmail(email);

        return user;
    }
}
