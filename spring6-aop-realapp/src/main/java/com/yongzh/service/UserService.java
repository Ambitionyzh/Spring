package com.yongzh.service;

import org.springframework.stereotype.Component;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 20:57
 */
@Component
public class UserService {
    public void getUser(){
        System.out.println("获取用户信息");
    }
    public void saveUser(){
        System.out.println("保存用户");
    }
    public void deleteUser(){
        System.out.println("删除用户");
    }
    public void modifyUser(){
        System.out.println("修改用户");
    }
}
