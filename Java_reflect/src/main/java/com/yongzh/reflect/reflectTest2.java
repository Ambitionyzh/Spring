package com.yongzh.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 21:37
 */
public class reflectTest2 {
    @Test
    public static void main(String[] args) throws Exception{
        String className = "com.yongzh.reflect.User";
        String propertyName = "age";

        Class<?> aClass = Class.forName(className);

        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

        Field field = aClass.getDeclaredField(propertyName);

        Method method = aClass.getDeclaredMethod(methodName,field.getType());

        Object object = aClass.newInstance();

        method.invoke(object,25);
        System.out.println(object);


    }
}
