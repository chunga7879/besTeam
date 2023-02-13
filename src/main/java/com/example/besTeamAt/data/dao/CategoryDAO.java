package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Category;

import java.util.List;

public interface CategoryDAO {
    Category save(Category category);

    Category deactivate(Long id) throws Exception;

    Category activate(Long id) throws Exception;

    List<Category> getAll();

    List<Category> getAllActivate();

    List<Category> getAllDeactivate();

}
