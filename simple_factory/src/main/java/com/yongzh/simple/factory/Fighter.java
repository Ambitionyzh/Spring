package com.yongzh.simple.factory;

/**
 * @author yongzh
 * @version 1.0
 * @description: 具体产品角色
 * @date 2023/12/30 9:39
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("歼16在起飞！！！");
    }
}
