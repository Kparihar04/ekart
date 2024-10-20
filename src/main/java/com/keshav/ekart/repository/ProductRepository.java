package com.keshav.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keshav.ekart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
