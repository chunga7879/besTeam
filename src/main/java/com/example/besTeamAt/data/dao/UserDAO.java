package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.User;

public interface UserDAO {

    User save(User user);

    User getById(Long id) throws Exception;
}
