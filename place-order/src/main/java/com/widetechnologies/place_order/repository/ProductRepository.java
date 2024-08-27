package com.widetechnologies.place_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.widetechnologies.place_order.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
