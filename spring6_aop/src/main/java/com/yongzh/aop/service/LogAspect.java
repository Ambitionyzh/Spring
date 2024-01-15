package com.yongzh.aop.service;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/14 22:54
 */
@Component("logAspect")
@Aspect //切面类需要使用此注解进行标注
@Order(2)
public class LogAspect {

    @Before("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void enhance(){
        System.out.println("增强--正在执行增强代码");
    }
    @Before("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    @AfterReturning("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    @AfterThrowing("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    @After("execution(* com.yongzh.aop.service.UserService.*(..))")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
