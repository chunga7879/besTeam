package com.example.besTeamAt.service;

import com.example.besTeamAt.data.dto.CategoryDto;
import com.example.besTeamAt.data.dto.RoleDto;

import java.util.List;

public interface CategoryService {
//    CategoryDto create(String name, List<Long> roleIds);

    CategoryDto activate(Long id) throws Exception;

    CategoryDto deactivate(Long id) throws Exception;

    List<CategoryDto> findAll();

    List<CategoryDto> getAllActivate();

    List<CategoryDto> getAllDeactivate();

}
