package com.test.bbf.service.impl;

import com.test.bbf.dao.ProductMapper;
import com.test.bbf.entity.Product;
import com.test.bbf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    @Cacheable(value = "testmybatis.product.allProducts",key = "'product.findAll'")//表示当前方法使用缓存，并存入redis数据库中
        //value属性：标识存入redis数据库的key（测试文字2）
        //key属性：用于指定方法执行返回值得key，该属性是spring用的，不写也有默认值
    public List<Product> getProductList() {
        System.out.println("从数据库中读取全部产品！");
        return productMapper.getProductList();
    }

    @Override
    @Cacheable(value = "testmybatis.product",key = "'product.findOne.'+#proId")//表示当前方法使用缓存，并存入redis数据库中
    public Product getProductById(String proId){
        System.out.println("从数据库中读取单个产品；proId="+proId+"！");
        return productMapper.getProductById(proId);
    }

    @Override
    @CacheEvict(value = "testmybatis.product",key = "'product.findOne.'+#product.proID")//表示当前方法使用缓存，并存入redis数据库中
    public int updateProduct(Product product){
        return productMapper.updateProduct(product);
    }
}
