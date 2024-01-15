package com.yongzh;

import com.yongzh.config.Spring6config;
import com.yongzh.service.AccountService;
import com.yongzh.service.OrderService;
import com.yongzh.service.ProductService;
import com.yongzh.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 20:53
 */
public class test {
    @Test
    public void testTransaction(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6config.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        // 生成订单
        orderService.generate();
        // 取消订单
        orderService.cancel();
        // 转账
        accountService.transfer();
        // 取款
        accountService.withdraw();
    }

    @Test
    public void testSecurity(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6config.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        userService.getUser();
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        productService.getProduct();
        productService.saveProduct();
        productService.deleteProduct();
        productService.modifyProduct();
    }
}
