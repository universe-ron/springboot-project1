package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.dto.CreateOrderRequest;
import com.ronwu.springbootproject1.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
