package com.yongzh.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 20:59
 */
@Component
@Aspect
public class SecurityAspect {
    @Pointcut("execution(* com.yongzh.service..save*(..))")
    public void savePointcut(){}

    @Pointcut("execution(* com.yongzh.service..delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* com.yongzh.service..modify*(..))")
    public void modifyPointcut(){}

    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdivce(JoinPoint joinpoint){
        System.out.println("XXX操作员正在操作"+joinpoint.getSignature().getName()+"方法");
    }
}
