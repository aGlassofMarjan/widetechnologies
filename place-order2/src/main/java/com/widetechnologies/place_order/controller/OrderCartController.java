package com.widetechnologies.place_order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.widetechnologies.place_order.entity.OrderCartItem;
import com.widetechnologies.place_order.service.OrderCartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class OrderCartController {
    private final OrderCartService orderCartService;

    // GET Cart
    @GetMapping
    public ResponseEntity<List<OrderCartItem>> getOrderCart() {
        return ResponseEntity.ok(orderCartService.getAllOrderCartItems());
    }

    // POST Cart
    @PostMapping("/add")
    public ResponseEntity<OrderCartItem> addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(orderCartService.addToCart(productId, quantity));
    }

    // POST Finalize order
    @PostMapping("place")
    public ResponseEntity<Void> placeOrder() {
        orderCartService.placeOrder();
        return ResponseEntity.ok().build();
    }
}
