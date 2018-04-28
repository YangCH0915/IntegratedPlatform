package com.xinruiyun.platform.service.user;

import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    int addUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

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
    int updatePassword(String userName,String password);

    /**
     * 分页查找
     * @return
     */
    List<UserInfo> queryUserByPage(PagingQuery pagingQuery);

    /**
     * 查询总数量
     */
    long queryAllCount(String founder);
}
