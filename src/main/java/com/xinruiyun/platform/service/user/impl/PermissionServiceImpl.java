package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.dao.user.PermissionDao;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.user.Permission;
import com.xinruiyun.platform.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public int addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission);
    }

    @Override
    public int deletePermissionById(int id) {
        return permissionDao.deletePermissionbyId(id);
    }

    @Override
    public int deletePermissionByName(String name) {
        return permissionDao.deletePermissionByName(name);
    }

    @Override
    public List<Permission> queryAllPermission() {
        return permissionDao.queryAllPermission();
    }

    @Override
    public Permission queryPermissionById(int id) {
        return permissionDao.queryPermissionById(id);
    }

    @Override
    public Permission queryPermissionByName(String name) {
        return permissionDao.queryPermissionByName(name);
    }

    @Override
    public List<Permission> queryPermissionByPage(PagingQuery pagingQuery) {
        return permissionDao.queryPermissionByPage(pagingQuery);
    }

    @Override
    public long queryAllCount() {
        return permissionDao.queryAllCount();
    }
}
