package com.ronwu.springbootproject1.service.impl;

import com.ronwu.springbootproject1.dao.ProductDao;
import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;
import com.ronwu.springbootproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    public Integer createProduct(ProductRequest productRequest){
        return productDao.createProduct(productRequest);
    }
}
