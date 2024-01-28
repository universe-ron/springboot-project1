package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.dto.ProductQueryParams;
import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;

import java.util.List;

public interface ProductDao {
    Integer countProduct(ProductQueryParams productQueryParams);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void updateStock(Integer productId,Integer stock);
    void deleteProductById(Integer productId);
}
