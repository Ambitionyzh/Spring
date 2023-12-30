package com.yongzh.simple.factory;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/30 9:42
 */
public class WeaponFactory {

    /** 
     * @description:  *萨态方法。要获取什么产品？就看你传什么参数，传TANK获取坦克，DAGGER获取匕首，FIGHTER获取战斗机
     * ★简单工厂模式中有一个静态方法，所以被称为：静态工厂方法模式
     * @param: WeaponType 
     * @return: com.yongzh.simple.factory.Weapon 
     * @author yongzh
     * @date: 2023/12/30 9:43
     */ 
    public static  Weapon get(String weaponType){
        if("TANK".equals(weaponType)){
            return new Tank();
        }else if("DAGGER".equals(weaponType)){
            return  new Dagger();
        } else if ("FIGHTER".equals(weaponType)) {
            return  new Fighter();
        }else{
            throw new RuntimeException("不支持");
        }
    }
}
