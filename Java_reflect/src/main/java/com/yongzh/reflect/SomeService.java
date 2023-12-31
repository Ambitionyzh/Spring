package com.yongzh.reflect;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 21:26
 */
public class SomeService {
    public void logout(){
        System.out.println("退出系统");
    }

    public boolean login(String username, String password){
        if ("wuhu".equals(username) && "qifei".equals(password)) {
            System.out.println("芜湖起飞！");
            return true;
        }
        System.out.println("密码错误");
        return false;
    }

    public boolean login(String password){
        if("110".equals(password)){
            return true;
        }
        return false;
    }
}
