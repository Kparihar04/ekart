package com.keshav.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keshav.ekart.model.Category;
import com.keshav.ekart.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> list = service.getAllCategory();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category category = service.getCategoryById(id);
        if(category == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category newCategory){
        service.createCategory(newCategory);
        return ResponseEntity.ok("New Categoty with name "+ newCategory.getCategoryName()+ " is Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){

        Category oldCategory = service.getCategoryById(id);
        if(oldCategory == null) return ResponseEntity.notFound().build();

        Category updatedCategory = service.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        
        Category oldCategory = service.getCategoryById(id);
        if(oldCategory == null) return ResponseEntity.ok("NOT FOUND : Category with id "+ id + " not found ");
        
        service.deleteCategory(id);
        return ResponseEntity.ok("Category with id "+ id + " deleted");
    }
}
