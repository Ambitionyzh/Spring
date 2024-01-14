package com.yongzh.proxy.service;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/4 22:27
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public void generate() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(2541);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单信息如下：******");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1010);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public String getName() {
        System.out.println("getName()方法执行了");
        return "wuhu";
    }
}
