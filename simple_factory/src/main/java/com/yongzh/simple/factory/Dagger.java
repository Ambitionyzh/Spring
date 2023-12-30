package com.yongzh.simple.factory;

/**
 * @author yongzh
 * @version 1.0
 * @description: 具体产品角色
 * @date 2023/12/30 9:40
 */
public class Dagger extends Weapon{

    @Override
    public void attack() {
        System.out.println("还有谁！！！");
    }
}
