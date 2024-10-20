package com.keshav.ekart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshav.ekart.model.Product;
import com.keshav.ekart.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product oldProduct = repo.findById(id).orElse(null);

        oldProduct.setProductName(product.getProductName());
        oldProduct.setProductDescription(product.getProductDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCategoryId(product.getCategoryId());

        repo.save(oldProduct);

        return oldProduct;
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
    
}
