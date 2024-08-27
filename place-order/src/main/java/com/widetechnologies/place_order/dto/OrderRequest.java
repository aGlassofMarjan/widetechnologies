package com.widetechnologies.place_order.dto;

import java.util.List;

import com.widetechnologies.place_order.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String customerName;
    private String customerAddress;
    private List<OrderItem> items;
}
