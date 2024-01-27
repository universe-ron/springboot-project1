package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
