package com.xinruiyun.platform.dao.cache;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RedisDaoTest extends BaseTest{

    private RedisDao redisDao = new RedisDao();

    @Test
    public void setObject() {

        List<Product> list = new ArrayList<>();

        Product p1 = new Product();
        p1.setProductId("1000");
        p1.setIsEnable(1);
        p1.setProductExplain("akjdflkajsdlfj");
        p1.setProductBg("adfsdfasdf");
        p1.setProductLogo("sdadsfa");
        p1.setProductName("asd");
        list.add(p1);

        Product p2 = new Product();
        p2.setProductId("2000");
        p2.setIsEnable(0);
        p2.setProductExplain("akjdflkajsdlfj");
        p2.setProductBg("adfsdfasdf");
        p2.setProductLogo("sdadsfa");
        p2.setProductName("asd");
        list.add(p2);

        Product p3 = new Product();
        p3.setProductId("3000");
        p3.setIsEnable(1);
        p3.setProductExplain("akjdflkajsdlfj");
        p3.setProductBg("adfsdfasdf");
        p3.setProductLogo("sdadsfa");
        p3.setProductName("asd");
        list.add(p3);

        System.out.println(list.toString());
    }

    @Test
    public void test(){
        System.out.println("ping-->"+redisDao.ping());
        System.out.println("hasKye-->"+redisDao.hasKey("12344"));
    }
}