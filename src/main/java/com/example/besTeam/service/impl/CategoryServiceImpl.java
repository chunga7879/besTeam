package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.CategoryDAO;
import com.example.besTeam.data.dto.CategoryDto;
import com.example.besTeam.data.entity.Category;
import com.example.besTeam.data.entity.Role;
import com.example.besTeam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    private Role roleDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @Override
    public CategoryDto create(String name) {
        // TODO: CATEGORY -> ADDING ROLE
        Category category = categoryDAO.save(Category.builder().name(name).roles(new ArrayList<>()).isDestroyed(false).build());

        return category.toDto();
    }

    @Override
    public CategoryDto getById(Long id) throws Exception {
        Category category = categoryDAO.getById(id);

        return category.toDto();
    }

    @Override
    public CategoryDto activate(Long id) throws Exception {
        Category category = categoryDAO.activate(id);
        return category.toDto();
    }

    @Override
    public CategoryDto deactivate(Long id) throws Exception {
        Category category = categoryDAO.deactivate(id);
        return category.toDto();
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> lists = new ArrayList<>();
        categoryDAO.getAll().forEach(categoryDAO -> lists.add(categoryDAO.toDto()));
        return lists;
    }

    @Override
    public List<CategoryDto> getAllActivate() {
        List<CategoryDto> lists = new ArrayList<>();
        categoryDAO.getAllActivate().forEach(categoryDAO -> lists.add(categoryDAO.toDto()));
        return lists;
    }

    @Override
    public List<CategoryDto> getAllDeactivate() {
        List<CategoryDto> lists = new ArrayList<>();
        categoryDAO.getAllDeactivate().forEach(categoryDAO -> lists.add(categoryDAO.toDto()));
        return lists;
    }
}
