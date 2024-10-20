package com.keshav.ekart.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshav.ekart.model.Category;
import com.keshav.ekart.repository.CategoryRepository;


@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> getAllCategory() {
       List<Category> list = repo.findAll();
       return list;
    }

    public Category getCategoryById(Long id) {
        Category category = repo.findById(id).orElse(null);
        return category;
    }

    public void createCategory(Category newCategory) {
        repo.save(newCategory);
    }

    public Category updateCategory(Long id, Category category) {

        Category oldCategory = getCategoryById(id);
        oldCategory.setCategoryName(category.getCategoryName());;
        oldCategory.setCategoryDescription(category.getCategoryDescription());
        return repo.save(oldCategory);
    }

    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }
    
}
