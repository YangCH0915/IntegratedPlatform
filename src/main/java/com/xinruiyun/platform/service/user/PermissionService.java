package com.xinruiyun.platform.service.user;

import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.user.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {

    int addPermission(@Param("p") Permission permission);

    int updatePermission(@Param("p") Permission permission);

    int deletePermissionById(int id);

    int deletePermissionByName(String name);

    List<Permission> queryAllPermission();

    Permission queryPermissionById(int id);

    Permission queryPermissionByName(String name);

    List<Permission> queryPermissionByPage(@Param("pq") PagingQuery pagingQuery);

    long queryAllCount();
}
