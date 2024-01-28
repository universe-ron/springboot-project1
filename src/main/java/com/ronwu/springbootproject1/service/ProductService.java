package com.ronwu.springbootproject1.service;

import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
