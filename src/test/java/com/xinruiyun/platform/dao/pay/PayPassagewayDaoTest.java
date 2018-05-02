package com.xinruiyun.platform.dao.pay;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PayPassagewayDaoTest extends BaseTest{

    @Autowired
    private PayPassagewayDao passagewayDao;

    @Test
    public void addPassageway() {
        PayPassageway pp = new PayPassageway();
        pp.setPassagewayName("华移");
        pp.setPassagewayId("1002537");
        pp.setPayType("wx_gzh");
        pp.setAppId("wx12564af456456");
        pp.setAppSecret("ajhjsdf456324156asdf");
        pp.setEncryptionType("MD5");
        pp.setMchId("15263486");
        pp.setMchKey("AJH238723489792835");
        pp.setIsUse(0);
        int i = passagewayDao.addPassageway(pp);
        System.out.println("增加是否成功："+i);
    }

    @Test
    public void deletePassageway() {
        int i = passagewayDao.deletePassageway(7);
        System.out.println("删除结果："+i);
    }

    @Test
    public void updatePassageway() {
        PayPassageway pp = new PayPassageway();
        pp.setId(6);
        pp.setPassagewayName("威富通");
        pp.setPassagewayId("1002536");
        pp.setPayType("wx_gzh");
        pp.setAppId("wx12564af456456");
        pp.setAppSecret("1234567890123");
        pp.setEncryptionType("MD5");
        pp.setMchId("15263485");
        pp.setMchKey("AJH238723489792834");
        pp.setIsUse(1);
        int i = passagewayDao.updatePassageway(pp);
        System.out.println("更新是否成功："+i);
    }

    @Test
    public void queryPassagewayById() {
        PayPassageway payPassageway = passagewayDao.queryPassagewayById(6);
        System.out.println("查询结果："+payPassageway.toString());
    }

    @Test
    public void queryPassagewayByPassagewayId() {
        PayPassageway payPassageway = passagewayDao.queryPassagewayByPassagewayId("1002536");
        System.out.println("查询结果："+payPassageway.toString());
    }

    @Test
    public void queryPassagewayListByPage() {
//        List<PayPassageway> payPassageways = passagewayDao.queryPassagewayListByPage();
//        System.out.println("查询结果："+payPassageways.toString());
    }

    @Test
    public void queryPassagewayCount() {
        long l = passagewayDao.queryPassagewayCount();
        System.out.println("查询结果："+l);
    }
}