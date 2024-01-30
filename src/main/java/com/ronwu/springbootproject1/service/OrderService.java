package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.dto.CreateOrderRequest;
import com.ronwu.springbootproject1.dto.OrderQueryParams;
import com.ronwu.springbootproject1.model.Order;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
