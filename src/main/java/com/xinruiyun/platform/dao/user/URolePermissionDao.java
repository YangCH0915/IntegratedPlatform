package com.xinruiyun.platform.dao.user;


import com.xinruiyun.platform.entity.user.URolePermission;
import java.util.List;
import java.util.Map;

public interface URolePermissionDao {
    int insert(URolePermission record);

    int insertSelective(URolePermission record);

	List<URolePermission> findRolePermissionByPid(Long id);
	
	List<URolePermission> findRolePermissionByRid(Long id);
	
	List<URolePermission> find(URolePermission entity);
	
	int deleteByPid(Long id);
	int deleteByRid(Long id);
	int delete(URolePermission entity);

	int deleteByRids(Map<String, Object> resultMap);
}