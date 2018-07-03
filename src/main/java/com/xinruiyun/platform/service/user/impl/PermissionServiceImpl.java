package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.dao.user.PermissionDao;
import com.xinruiyun.platform.dto.UPermission;
import com.xinruiyun.platform.entity.user.Permission;
import com.xinruiyun.platform.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return permissionDao.deletePermissionById(id);
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
    public List<UPermission> queryPermissionByRoleId(int id) {
        return permissionDao.queryPermissionByRoleId(id);
    }

}
