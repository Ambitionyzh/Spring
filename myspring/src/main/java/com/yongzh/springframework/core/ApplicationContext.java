package com.yongzh.springframework.core;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 22:40
 */
public interface ApplicationContext {
    Object getBean(String beanName);
}
