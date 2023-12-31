package com.yongzh.myspring.bean;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 22:30
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
