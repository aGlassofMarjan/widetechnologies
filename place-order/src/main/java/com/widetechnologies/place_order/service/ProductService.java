package com.widetechnologies.place_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.widetechnologies.place_order.entity.Product;
import com.widetechnologies.place_order.repository.ProductRepository;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
