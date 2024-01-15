package com.yongzh.aop.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 20:29
 */
@ComponentScan("com.yongzh.aop.service")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6config {
}
