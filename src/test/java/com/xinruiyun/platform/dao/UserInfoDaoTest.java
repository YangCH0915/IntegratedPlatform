package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dao.user.UserInfoDao;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.user.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoDaoTest extends BaseTest{

    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void addUserInfo() {
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void deleteUserByUsername() {
    }

    @Test
    public void queryAllUserInfo() {
    }

    @Test
    public void queryUserByJurisdiction() {
    }

    @Test
    public void queryUserById() {
    }

    @Test
    public void queryUserByUsername() {
        PagingQuery pq = new PagingQuery();
        pq.setPageIndex(0);
        pq.setPageSize(5);
        List<UserInfo> userInfos = userInfoDao.queryUserByPage(pq);
        System.out.println("查询结果："+userInfos.toString());
    }

    @Test
    public void updatePassword() {
    }
}