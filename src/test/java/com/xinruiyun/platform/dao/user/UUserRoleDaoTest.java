package com.xinruiyun.platform.dao.user;

import com.xinruiyun.platform.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UUserRoleDaoTest extends BaseTest {

    @Autowired
    private UUserRoleDao uUserRoleDao;

    @Test
    public void insert() {

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void deleteByUserId() {
    }

    @Test
    public void findUserIdByRoleId() {
        List<Long> userIdByRoleId = uUserRoleDao.findUserIdByRoleId(1);
        System.out.println(userIdByRoleId.toString());
    }
}