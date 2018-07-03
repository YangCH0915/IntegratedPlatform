package com.xinruiyun.platform.dao.user;

import com.xinruiyun.platform.entity.user.UUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UUserRoleDao {

    int insert(@Param("ur")UUserRole record);

    int insertSelective(@Param("ur")UUserRole record);

	int deleteById(int id);

	List<Long> findUserIdByRoleId(int id);
}