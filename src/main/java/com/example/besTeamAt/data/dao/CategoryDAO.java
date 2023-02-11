package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Category;

public interface CategoryDAO {
    Category saveCategory(Category category);

    Category deactivateCategory(Long id) throws Exception;

    Category activateCategory(Long id) throws Exception;
}
