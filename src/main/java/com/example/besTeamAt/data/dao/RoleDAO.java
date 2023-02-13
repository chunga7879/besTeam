package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Role;

public interface RoleDAO {
    Role getRoleById(Long id) throws Exception;

    Role saveRole(Role role);
}
