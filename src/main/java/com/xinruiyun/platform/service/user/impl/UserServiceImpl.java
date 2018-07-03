package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.dao.user.UserInfoDao;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.dto.URole;
import com.xinruiyun.platform.entity.user.UserInfo;
import com.xinruiyun.platform.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        UserInfo ui = queryUserByUsername(userInfo.getUserName());
        if(ui != null){
            return -1;
        }
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        userInfo.setUpdateTime(new Date());
        UserInfo ui = queryUserByUsername(userInfo.getUserName());
        if(ui == null){
            return -1;
        }
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserById(int id) {
        return userInfoDao.deleteUserById(id);
    }

    @Override
    public int updateState(int id, int state) {
        return userInfoDao.updateState(id,state);
    }

    @Override
    public int deleteUserByUsername(String userName) {
return userInfoDao.deleteUserByUsername(userName);
    }

    @Override
    public List<UserInfo> queryAllUserInfo() {
        return userInfoDao.queryAllUserInfo();
    }

    @Override
    public List<URole> queryRoleByUserId(long id) {
        return userInfoDao.queryRoleByUserId(id);
    }

    @Override
    public UserInfo queryUserById(int id) {
        return userInfoDao.queryUserById(id);
    }

    @Override
    public UserInfo queryUserByUsername(String userName) {
        return userInfoDao.queryUserByUsername(userName);
    }

    @Override
    public int updatePassword(String userName, String password) {
      return userInfoDao.updatePassword(userName,password);
    }

    @Override
    public List<UserInfo> queryUserByPage(PagingQuery pagingQuery) {
        UserInfo userInfo = queryUserByUsername(pagingQuery.getOperator());
        if(userInfo == null){
            return null;
        }
        int offset = (int) (pagingQuery.getTotalRecords() - (pagingQuery.getPageSize()*pagingQuery.getPageIndex()));
        if(offset<0){
            pagingQuery.setPageSize(pagingQuery.getPageSize()+offset);
            offset = 0;
            pagingQuery.setPageIndex(offset);
        }else{
            pagingQuery.setPageIndex(offset);
        }
        return userInfoDao.queryUserByPage(pagingQuery);
    }

    @Override
    public long queryAllCount(String userName) {
        UserInfo userInfo = queryUserByUsername(userName);
        if(userInfo == null){
            return 0;
        }
        return userInfoDao.queryAllCount(userName);
    }
}
