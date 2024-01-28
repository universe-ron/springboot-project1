package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.constant.ProductCategory;
import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
