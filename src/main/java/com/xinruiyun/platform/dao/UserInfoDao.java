package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    int addUserInfo(@Param("user") UserInfo userInfo);

    int updateUserInfo(@Param("user") UserInfo userInfo);

    int deleteUserById(int id);

    int deleteUserByUsername(String userName);

    List<UserInfo> queryAllUserInfo();

    /**
     * 查询某个权限的用户
     * @param jurisdiction
     * @return
     */
    List<UserInfo> queryUserByJurisdiction(int jurisdiction);

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
     * @param offset 开始位置
     * @param limit 查询多少条
     * @return
     */
    List<UserInfo> queryUserByPage(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 查询总数量
     */
    long queryAllCount();
}
