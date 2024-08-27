package com.widetechnologies.place_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.widetechnologies.place_order.entity.Product;
import com.widetechnologies.place_order.repository.ProductRepository;

@Service
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
