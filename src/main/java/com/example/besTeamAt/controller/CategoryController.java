package com.example.besTeamAt.controller;

import com.example.besTeamAt.data.dto.CategoryDto;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
    public CategoryDto create(@Valid @RequestParam String name) {
        return categoryService.create(name);
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
