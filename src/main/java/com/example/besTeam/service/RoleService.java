package com.example.besTeam.service;

import com.example.besTeam.data.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(String name, List<String> abilities);

    RoleDto getRoleById(Long id) throws Exception;
}
