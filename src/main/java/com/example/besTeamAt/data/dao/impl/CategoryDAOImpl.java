package com.example.besTeamAt.data.dao.impl;

import com.example.besTeamAt.data.dao.CategoryDAO;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDAOImpl implements CategoryDAO {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deactivate(Long id) throws Exception {
        categoryRepository.IsDestroyed(id, true);
        return categoryRepository.findById(id).orElseThrow(() -> new Exception("category by id not exist"));
    }

    @Override
    public Category activate(Long id) throws Exception {
        categoryRepository.IsDestroyed(id, false);
        return categoryRepository.findById(id).orElseThrow(() -> new Exception("category by id not exist"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllActivate() {
        return categoryRepository.findAllByIsDestroyedEquals(false);
    }

    @Override
    public List<Category> getAllDeactivate() {
        return categoryRepository.findAllByIsDestroyedEquals(true);
    }
}
