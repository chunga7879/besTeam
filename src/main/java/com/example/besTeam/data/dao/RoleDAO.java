package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Role;

public interface RoleDAO {
    Role getRoleById(Long id) throws Exception;

    Role saveRole(Role role);
}
