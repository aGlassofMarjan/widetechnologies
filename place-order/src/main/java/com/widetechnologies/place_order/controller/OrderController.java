package com.widetechnologies.place_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widetechnologies.place_order.dto.OrderRequest;
import com.widetechnologies.place_order.entity.Order;
import com.widetechnologies.place_order.entity.OrderItem;
import com.widetechnologies.place_order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PostMapping("/{id}/items")
    public Order addItemToOrder(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            order.addItem(orderItem);
            return orderService.saveOrder(order);
        }
        return null;
    }

    @DeleteMapping("/{id}/items/{itemId}")
    public Order removeItemFromOrder(@PathVariable Long id, @PathVariable Long itemId) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            OrderItem itemToRemove = order.getItems().stream()
                    .filter(item -> item.getId().equals(itemId))
                    .findFirst()
                    .orElse(null);
            if (itemToRemove != null) {
                order.removeItem(itemToRemove);
                return orderService.saveOrder(order);
            }
        }
        return null;
    }
}
