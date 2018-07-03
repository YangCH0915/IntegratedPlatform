package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dto.UPermission;
import com.xinruiyun.platform.service.user.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PermissionServiceImplTest extends BaseTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void addPermission() {
    }

    @Test
    public void updatePermission() {
    }

    @Test
    public void deletePermissionById() {
    }

    @Test
    public void queryAllPermission() {
    }

    @Test
    public void queryPermissionById() {
    }

    @Test
    public void queryPermissionByRoleId() {
        List<UPermission> uPermissions = permissionService.queryPermissionByRoleId(3);
        System.out.println(uPermissions);
    }
}