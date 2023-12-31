package com.yongzh.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 21:27
 */
public class reflectTest {
    @Test
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.yongzh.reflect.SomeService");
        Method login = aClass.getDeclaredMethod("login", String.class, String.class);
        Object object = aClass.newInstance();
        login.invoke(object,"wuhu","qifei");

    }
}
