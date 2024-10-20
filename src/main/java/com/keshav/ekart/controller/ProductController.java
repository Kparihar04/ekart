package com.keshav.ekart.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keshav.ekart.model.Product;
import com.keshav.ekart.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = service.getAllProduct();
        return ResponseEntity.ok(products);
    }

	// • GET /api/products/{id} - Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = service.getProductById(id);
        if(product == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }
	// • POST /api/products - Create a new product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = service.addProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
    
	// • PUT /api/products/{id} - Update a product by ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        Product updatedProduct = service.getProductById(id);
        if(updatedProduct == null) return ResponseEntity.notFound().build();

        updatedProduct = service.updateProduct(id,product);
        return ResponseEntity.ok(updatedProduct);
    }
    // • DELETE /api/products/{id} - Delete a product by ID
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        
        Product oldProduct = service.getProductById(id);
        if(oldProduct == null) return ResponseEntity.ok("NOT FOUND : Product with id "+ id + " not found ");
        
        service.deleteProduct(id);
        return ResponseEntity.ok("Product with id "+ id + " deleted");
    }
}
