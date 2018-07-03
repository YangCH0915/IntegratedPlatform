package com.xinruiyun.platform.dao.user;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.user.Role;
import com.xinruiyun.platform.service.user.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class RoleDaoTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() {
    }

    @Test
    public void updateRole() {

    }

    @Test
    public void deleteRoleById() {
        int i = roleService.deleteRoleById(4);
        System.out.println(i);
    }

    @Test
    public void queryAllRole() {
        List<Role> roles = roleService.queryAllRole();
        System.out.println(roles.toString());
    }

    @Test
    public void queryRoleById() {
        Role role = roleService.queryRoleById(1);
        System.out.println(role.toString());
    }

    @Test
    public void queryRoleByName() {
    }

    @Test
    public void queryRoleByPage() {
    }

    @Test
    public void queryAllCount() {
    }
}