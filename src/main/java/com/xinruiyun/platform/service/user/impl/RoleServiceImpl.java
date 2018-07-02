package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.dao.user.RoleDao;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.user.Role;
import com.xinruiyun.platform.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRoleById(long id) {
        return roleDao.deleteRolebyId(id);
    }

    @Override
    public int deleteUserByName(String name) {
        return roleDao.deleteUserByName(name);
    }

    @Override
    public List<Role> queryAllRole() {
        return roleDao.queryAllRole();
    }

    @Override
    public Role queryRoleById(long id) {
        return roleDao.queryRoleById(id);
    }

    @Override
    public Role queryRoleByName(String name) {
        return roleDao.queryRoleByName(name);
    }

    @Override
    public List<Role> queryRoleByPage(PagingQuery pagingQuery) {
        return roleDao.queryRoleByPage(pagingQuery);
    }

    @Override
    public long queryAllCount() {
        return roleDao.queryAllCount();
    }
}
