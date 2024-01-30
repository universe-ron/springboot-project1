package com.ronwu.springbootproject1.service.impl;

import com.ronwu.springbootproject1.dao.OrderDao;
import com.ronwu.springbootproject1.dao.ProductDao;
import com.ronwu.springbootproject1.dto.BuyItem;
import com.ronwu.springbootproject1.dto.CreateOrderRequest;
import com.ronwu.springbootproject1.model.OrderItem;
import com.ronwu.springbootproject1.model.Product;
import com.ronwu.springbootproject1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount=0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價錢
            int amount = buyItem.getQuantity()*product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換BuyItem to OrderItem()
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId,totalAmount);
        orderDao.createOrderItems(orderId,orderItemList);
        return orderId;
    }
}
