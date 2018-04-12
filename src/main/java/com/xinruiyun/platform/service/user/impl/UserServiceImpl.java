package com.xinruiyun.platform.service.user.impl;

import com.xinruiyun.platform.dao.UserInfoDao;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserById(int id) {
        return userInfoDao.deleteUserById(id);
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
    public List<UserInfo> queryUserByJurisdiction(int jurisdiction) {
        return userInfoDao.queryUserByJurisdiction(jurisdiction);
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
    public List<UserInfo> queryUserByPage(int offset, int limit) {
        return userInfoDao.queryUserByPage(offset,limit);
    }

    @Override
    public long queryAllCount() {
        return userInfoDao.queryAllCount();
    }
}
