package com.example.besTeam.service;

import com.example.besTeam.data.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto create(String name);

    CategoryDto getById(Long id) throws Exception;

    CategoryDto activate(Long id) throws Exception;

    CategoryDto deactivate(Long id) throws Exception;

    List<CategoryDto> findAll();

    List<CategoryDto> getAllActivate();

    List<CategoryDto> getAllDeactivate();

}
