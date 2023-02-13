package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Category;

import java.util.List;

public interface CategoryDAO {
    Category save(Category category);

    Category getById(Long id) throws Exception;

    Category deactivate(Long id) throws Exception;

    Category activate(Long id) throws Exception;

    List<Category> getAll();

    List<Category> getAllActivate();

    List<Category> getAllDeactivate();

}
