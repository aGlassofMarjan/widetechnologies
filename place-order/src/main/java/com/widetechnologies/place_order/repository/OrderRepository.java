package com.widetechnologies.place_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.widetechnologies.place_order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
