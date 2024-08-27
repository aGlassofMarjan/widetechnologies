package com.widetechnologies.place_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widetechnologies.place_order.dto.OrderRequest;
import com.widetechnologies.place_order.entity.Order;
import com.widetechnologies.place_order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest.getCustomerName(), orderRequest.getCustomerAddress(), orderRequest.getItems());
    }
}
