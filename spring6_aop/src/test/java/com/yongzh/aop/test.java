package com.yongzh.aop;

import com.yongzh.aop.service.Spring6config;
import com.yongzh.aop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/14 23:02
 */
public class test {

    @Test
    public void testNoxml(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6config.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
    }

    @Test
    public void testAOP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
        //userService.logout();
    }
}
