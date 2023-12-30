package com.yongzh.simple.factory;

/**
 * @author yongzh
 * @version 1.0
 * @description: 具体产品角色
 * @date 2023/12/30 9:37
 */
public class Tank extends Weapon {
    @Override
    public void attack() {
        System.out.println("坦克可以开炮");
    }
}
