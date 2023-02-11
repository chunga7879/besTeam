package com.example.besTeamAt.service.impl;

import com.example.besTeamAt.data.dao.CategoryDAO;
import com.example.besTeamAt.data.dto.CategoryDto;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @Override
    public CategoryDto create(String name) {
        Category category = categoryDAO.saveCategory(Category.builder().name(name).isDestroyed(false).build());
        return category.toDto();
    }

    @Override
    public CategoryDto activate(Long id) throws Exception {
        Category category = categoryDAO.activateCategory(id);
        return category.toDto();
    }

    @Override
    public CategoryDto deactivate(Long id) throws Exception {
        Category category = categoryDAO.deactivateCategory(id);
        return category.toDto();
    }
}
