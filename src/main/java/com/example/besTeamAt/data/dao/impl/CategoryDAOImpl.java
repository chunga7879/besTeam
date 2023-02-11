package com.example.besTeamAt.data.dao.impl;

import com.example.besTeamAt.data.dao.CategoryDAO;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAOImpl implements CategoryDAO {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deactivateCategory(Long id) throws Exception {
        categoryRepository.IsDestroyed(id, true);
        return categoryRepository.findById(id).orElseThrow(() -> new Exception("category by id not exist"));
    }

    @Override
    public Category activateCategory(Long id) throws Exception {
        categoryRepository.IsDestroyed(id, false);
        return categoryRepository.findById(id).orElseThrow(() -> new Exception("category by id not exist"));
    }
}
