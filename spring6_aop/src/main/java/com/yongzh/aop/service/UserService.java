package com.yongzh.aop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/14 22:52
 */
@Service("userService")
public class UserService {//目标类
    public void login(){//目标方法
        System.out.println("系统正在进行身份认证。。。");
    }
    public void logout(){
        System.out.println("系统正在退出。。。");
    }
}
