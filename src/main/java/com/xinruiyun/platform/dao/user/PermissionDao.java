package com.xinruiyun.platform.dao.user;

import com.xinruiyun.platform.dto.UPermission;
import com.xinruiyun.platform.entity.user.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {

    int addPermission(@Param("p") Permission permission);

    int updatePermission(@Param("p") Permission permission);

    int deletePermissionById(int id);

    List<Permission> queryAllPermission();

    Permission queryPermissionById(int id);

    List<UPermission> queryPermissionByRoleId(int id);
}
