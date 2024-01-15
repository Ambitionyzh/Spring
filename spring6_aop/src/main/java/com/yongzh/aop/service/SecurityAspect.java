package com.yongzh.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/14 23:36
 */
@Component
@Aspect
@Order(1)
public class SecurityAspect {
    @Before("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void beforeAdvic(){
        System.out.println("前置通知：安全。。。");
    }
}
