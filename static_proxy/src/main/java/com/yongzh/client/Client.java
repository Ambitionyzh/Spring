package com.yongzh.client;

import com.yongzh.proxy.OrderService;
import com.yongzh.proxy.OrderServiceImpl;
import com.yongzh.proxy.OrderServiceProxy;

/**
 * @author yongzh
 * @version 1.0
 * @description: 静态代理的优点是符合OCP原则，缺点是如果接口太多会导致类爆炸。
 * @date 2024/1/4 22:29
 */
public class Client {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderService proxy = new OrderServiceProxy(orderService);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
