package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dto.URole;
import com.xinruiyun.platform.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryRoleByUserId() {
        List<URole> uRoles = userService.queryRoleByUserId(4);
        for(URole u:uRoles){
            System.out.println(u.toString());
        }
    }
}