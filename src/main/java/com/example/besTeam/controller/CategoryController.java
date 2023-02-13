package com.example.besTeam.controller;

import com.example.besTeam.data.dto.CategoryDto;
import com.example.besTeam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/create")
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto.getName());
    }

    @GetMapping(value = "/{id}")
    public CategoryDto getById(@PathVariable Long id) throws Exception {
        return categoryService.getById(id);
    }

    @GetMapping(value = "/all")
    public List<CategoryDto> getAll() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/all/active")
    public List<CategoryDto> getAllActivate() {
        return categoryService.getAllActivate();
    }

    @GetMapping(value = "/all/inactive")
    public List<CategoryDto> getAllDeactivate() {
        return categoryService.getAllDeactivate();
    }


    @PatchMapping(value = "/deactivate/{id}")
    public CategoryDto deactivate(@PathVariable Long id) throws Exception {
        return categoryService.deactivate(id);
    }

    @PatchMapping(value = "/activate/{id}")
    public CategoryDto activate(@PathVariable Long id) throws Exception {
        return categoryService.activate(id);
    }
}
