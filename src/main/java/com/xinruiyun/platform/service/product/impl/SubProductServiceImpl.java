package com.xinruiyun.platform.service.product.impl;

import com.xinruiyun.platform.dao.SubProductDao;
import com.xinruiyun.platform.entity.SubProduct;
import com.xinruiyun.platform.service.product.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubProductServiceImpl implements SubProductService{

    @Autowired
    private SubProductDao subProductDao;

    @Override
    public int addSubProduct(SubProduct subProduct) {
        return subProductDao.addSubProduct(subProduct);
    }

    @Override
    public int deleteSubProduct(int id) {
        return subProductDao.deleteSubProduct(id);
    }

    @Override
    public int updateSubProduct(SubProduct subProduct) {
        return subProductDao.updateSubProduct(subProduct);
    }

    @Override
    public SubProduct querySubProduct(int id) {
        return subProductDao.querySubProduct(id);
    }

    @Override
    public List<SubProduct> querySubProductList() {
        return subProductDao.querySubProductList();
    }

    @Override
    public List<SubProduct> querySubProductListByProductId(String productId) {
        return subProductDao.querySubProductListByProductId(productId);
    }

    @Override
    public long querySubProductCount() {
        return subProductDao.querySubProductCount();
    }
}
