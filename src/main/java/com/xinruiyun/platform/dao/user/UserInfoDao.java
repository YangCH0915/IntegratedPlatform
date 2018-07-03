package com.xinruiyun.platform.dao.user;

import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.dto.URole;
import com.xinruiyun.platform.entity.user.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    int addUserInfo(@Param("user") UserInfo userInfo);

    int updateUserInfo(@Param("user") UserInfo userInfo);

    int deleteUserById(int id);

    int updateState(@Param("id") int id,@Param("state") int state);

    int deleteUserByUsername(String userName);

    List<UserInfo> queryAllUserInfo();

    /**
     * 查询某个权限的用户
     * @param id
     * @return
     */
    List<URole> queryRoleByUserId(long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserInfo queryUserById(int id);

    /**
     * 根据用户名查询
     * @param
     * @return
     */
    UserInfo queryUserByUsername(String userName);

    /**
     * 根据渠道ID修改密码
     * @param
     * @return
     */
    int updatePassword(@Param("userName") String userName,@Param("password")String password);

    /**
     * 分页查找
     * @return
     */
    List<UserInfo> queryUserByPage(@Param("pq") PagingQuery pagingQuery);

    /**
     * 查询总数量
     */
    long queryAllCount(@Param("founder") String founder);
}
