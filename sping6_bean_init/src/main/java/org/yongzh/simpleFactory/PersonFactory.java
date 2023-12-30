package org.yongzh.simpleFactory;


import org.yongzh.bean.Person;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/30 11:52
 */
public class PersonFactory {
    public static Vip get(){
        return new Vip();
    }
}
