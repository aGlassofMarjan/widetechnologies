package com.widetechnologies.place_order.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.widetechnologies.place_order.entity.OrderCartItem;
import com.widetechnologies.place_order.entity.Product;
import com.widetechnologies.place_order.repository.OrderCartItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCartService {
    
    private final OrderCartItemRepository orderCartItemRepository;
    private final ProductService productService;

    public List<OrderCartItem> getAllOrderCartItems() {
        return orderCartItemRepository.findAll();
    }

    public OrderCartItem addToCart(Long productId, int quantity) {
        Product product = productService.getProductById(productId);

        productService.reduceProductQuantity(productId, quantity);

        Optional<OrderCartItem> existingItem = orderCartItemRepository.findAll()
                .stream()
                .filter(item -> item.getName().equals(product.getName()))
                .findFirst();

        if (existingItem.isPresent()) {
            OrderCartItem orderCartItem = existingItem.get();
            orderCartItem.setQuantity(orderCartItem.getQuantity() + quantity);
            return orderCartItemRepository.save(orderCartItem);
        } else {
            OrderCartItem newItem = new OrderCartItem();
            newItem.setName(product.getName());
            newItem.setType(product.getType());
            newItem.setPrice(product.getPrice());
            newItem.setQuantity(quantity);
            return orderCartItemRepository.save(newItem);
        }
    }

    public void placeOrder() {
        orderCartItemRepository.deleteAll();
    }
}
