package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.model.Order;
import com.ronwu.springbootproject1.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
