package com.ronwu.springbootproject1.dao;

import com.ronwu.springbootproject1.constant.ProductCategory;
import com.ronwu.springbootproject1.dto.ProductRequest;
import com.ronwu.springbootproject1.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void updateStock(Integer productId,Integer stock);
    void deleteProductById(Integer productId);
}
