package com.adarsh.libraryms.service;

import com.adarsh.libraryms.entity.Category;
import com.adarsh.libraryms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category addCategory(Category category) {
        return repository.save(category);
    }

    public List<Category> addcategorys(List<Category> categorys) {
        return repository.saveAll(categorys);
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Category updateCategory(Integer id, Category category) {
        Category existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(category.getName());

        return repository.save(existing);
    }

    public String deleteCategory(Integer id) {
        repository.deleteById(id);
        return "Category deleted successfully";
    }
}
