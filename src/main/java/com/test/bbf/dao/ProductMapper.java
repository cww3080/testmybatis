package com.test.bbf.dao;

import com.test.bbf.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select * from product")
    List<Product> getProductList();

    Product getProductById(String proId);
    int updateProduct(Product product);
}
