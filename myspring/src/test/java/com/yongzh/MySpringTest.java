package com.yongzh;

import com.yongzh.myspring.bean.UserService;
import com.yongzh.springframework.core.ApplicationContext;
import com.yongzh.springframework.core.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 23:46
 */
public class MySpringTest {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
