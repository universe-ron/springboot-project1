package com.ronwu.springbootproject1.service.impl;

import com.ronwu.springbootproject1.dao.OrderDao;
import com.ronwu.springbootproject1.dao.ProductDao;
import com.ronwu.springbootproject1.dao.UserDao;
import com.ronwu.springbootproject1.dto.BuyItem;
import com.ronwu.springbootproject1.dto.CreateOrderRequest;
import com.ronwu.springbootproject1.model.Order;
import com.ronwu.springbootproject1.model.OrderItem;
import com.ronwu.springbootproject1.model.Product;
import com.ronwu.springbootproject1.model.User;
import com.ronwu.springbootproject1.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl  implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);
        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderItemList);
        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        //檢查user是否存在
        User user = userDao.getUserById(userId);
        if (user == null) {
            log.warn("該userId{}不存在",userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        int totalAmount=0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            //檢查product是否存在 庫存是否足夠
            if(product==null){
                log.warn("商品{}不存在",buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            //扣除商品庫存
            productDao.updateStock(product.getProductId(),product.getStock()-buyItem.getQuantity();


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
