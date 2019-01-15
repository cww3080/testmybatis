package com.test.bbf.service.impl;

import com.test.bbf.dao.ProductMapper;
import com.test.bbf.entity.Product;
import com.test.bbf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

//@ComponentScan({"com.test.bbf.dao"})
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Cacheable(value = "findAllProducts",key = "'product.findAll'")//表示当前方法使用缓存，并存入redis数据库中
        //value属性：标识存入redis数据库的key
        //key属性：用于指定方法执行返回值得key，该属性是spring用的，不写也有默认值
    public List<Product> getProductList() {
        System.out.println("从数据库中读取！");
        return productMapper.getProductList();
    }
}
