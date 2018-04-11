package com.xinruiyun.platform.service.product.impl;

import com.xinruiyun.platform.dao.ProductDao;
import com.xinruiyun.platform.entity.Product;
import com.xinruiyun.platform.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int deleteProduct(String productId) {
        return productDao.deleteProduct(productId);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Product queryProductAndSubProduct(String productId) {
        return productDao.queryProductAndSubProduct(productId);
    }

    @Override
    public List<Product> queryProductList() {
        return productDao.queryProductList();
    }
}
