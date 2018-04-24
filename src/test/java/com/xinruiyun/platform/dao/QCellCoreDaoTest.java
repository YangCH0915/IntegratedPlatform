package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.QCellCore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class QCellCoreDaoTest extends BaseTest{

    @Autowired
    public QCellCoreDao qCellCoreDao;

    @Test
    public void getQCellCoreBysectionNo() {
        QCellCore qCellCoreBysectionNo = qCellCoreDao.getQCellCoreBysectionNo("1342900");
        System.out.println("查询结果："+qCellCoreBysectionNo.toString());
    }
}