package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.User;
import com.example.besTeamAt.data.entity.User;

public interface UserDAO {

    User saveUser(User user);

    User findById(Long id) throws Exception;
}
