package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
