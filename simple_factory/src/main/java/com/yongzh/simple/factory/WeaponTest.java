package com.yongzh.simple.factory;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/30 9:47
 */
public class WeaponTest {
    public static void main(String[] args) {

        //需要坦克
        Weapon tank =  WeaponFactory.get("TANK");
        tank.attack();
        //需要匕首
        Weapon dagger =  WeaponFactory.get("DAGGER");
        dagger.attack();
        //需要战斗机
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();

    }
}
