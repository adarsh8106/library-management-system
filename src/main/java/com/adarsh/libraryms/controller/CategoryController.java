package com.adarsh.libraryms.controller;

import com.adarsh.libraryms.entity.Category;
import com.adarsh.libraryms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }

    @PostMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Category> addcategorys(@RequestBody List<Category> categorys) {return service.addcategorys(categorys);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN','USER')")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN','USER')")
    public Category getCategory(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Category updateCategory(@PathVariable Integer id,
                                   @RequestBody Category category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCategory(@PathVariable Integer id) {
        return service.deleteCategory(id);
    }
}