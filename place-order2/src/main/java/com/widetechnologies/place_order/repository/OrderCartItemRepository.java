package com.widetechnologies.place_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widetechnologies.place_order.entity.OrderCartItem;

@Repository
public interface OrderCartItemRepository extends JpaRepository<OrderCartItem, Long> {
    
}
