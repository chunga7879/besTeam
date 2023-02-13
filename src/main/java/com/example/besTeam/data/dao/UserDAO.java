package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.User;

public interface UserDAO {

    User save(User user);

    User getById(Long id) throws Exception;
}
