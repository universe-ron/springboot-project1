package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
