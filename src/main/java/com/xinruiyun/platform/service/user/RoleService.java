package com.xinruiyun.platform.service.user;

import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.user.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    int addRole(@Param("role") Role role);

    int updateRole(@Param("role") Role role);

    int deleteRoleById(long id);

    int deleteUserByName(String name);

    List<Role> queryAllRole();

    Role queryRoleById(long id);

    Role queryRoleByName(String userName);

    List<Role> queryRoleByPage(@Param("pq") PagingQuery pagingQuery);

    long queryAllCount();
}
