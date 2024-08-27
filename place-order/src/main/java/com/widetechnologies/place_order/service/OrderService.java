package com.widetechnologies.place_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetechnologies.place_order.entity.Order;
import com.widetechnologies.place_order.entity.OrderItem;
import com.widetechnologies.place_order.repository.OrderRepository;
import com.widetechnologies.place_order.repository.ProductRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(String customerName, String customerAddress, List<OrderItem> items) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        order.setItems(items);
        order.setTotalAmount(calculateTotal(items));
        return orderRepository.save(order);
    }

    private double calculateTotal(List<OrderItem> items) {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }
}
