package com.test.bbf.service;

import com.test.bbf.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();
    Product getProductById(String proId);
    int updateProduct(Product product);
}
