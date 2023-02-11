package com.example.besTeamAt.service;

import com.example.besTeamAt.data.dto.CategoryDto;

public interface CategoryService {
    CategoryDto create(String name);

    CategoryDto activate(Long id) throws Exception;

    CategoryDto deactivate(Long id) throws Exception;
}
