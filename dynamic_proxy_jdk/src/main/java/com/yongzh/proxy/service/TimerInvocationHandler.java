package com.yongzh.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yongzh
 * @version 1.0
 * @description: 编写动态代理的增强代码
 * @date 2024/1/5 12:26
 */
public class TimerInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;
    // 通过构造方法来传目标对象
    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @description:
     * 1.为什么要实现InvocationHandler接口？ 为了实现invoke方法。因为JDK在底层调用nvoke()方法的程序己经提前写好了，并负责调用。
     * 2.invoke方法什么时候被调用呢？当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用，
     * @param: proxy  代理对象的引用
     * @param: method 要执行的目标对象的方法
     * @param: args 目标方法上的实参。
     * @return: java.lang.Object
     * @author yongzh
     * @date: 2024/1/14 19:39
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        // 目标执行之前增强。
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        Object retValue = method.invoke(target, args);
        // 目标执行之后增强。
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
        // 一定要记得返回哦。
        return retValue;
    }
}
