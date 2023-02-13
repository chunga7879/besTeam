package com.example.besTeamAt.service;

import com.example.besTeamAt.data.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(String name, List<String> abilities);

    RoleDto getRoleById(Long id) throws Exception;
}
