package com.yongzh.proxy.util;

import com.yongzh.proxy.service.OrderService;
import com.yongzh.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author yongzh
 * @version 1.0
 * @description: 动态代理工具类封装
 * @date 2024/1/14 19:51
 */
public class ProxyUtil {
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
