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
        // 1. get product detail
        Product product = productService.getProductById(productId);

        // 2. reduce product quantity
        productService.reduceProductQuantity(productId, quantity);

        // search if item already exist 
        Optional<OrderCartItem> existingItem = orderCartItemRepository.findAll()
                .stream()
                .filter(item -> item.getName().equals(product.getName()))
                .findFirst();

        // if already item exist => just add quantity = else => create new cart item
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

    // if order finalized, items will be deleted
    public void placeOrder() {
        orderCartItemRepository.deleteAll();
    }
}
