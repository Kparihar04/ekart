package com.keshav.ekart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "category_id")
    private Long categoryId;
    
}
