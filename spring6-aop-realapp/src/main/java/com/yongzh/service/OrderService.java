package com.yongzh.service;

import org.springframework.stereotype.Component;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 20:49
 */
@Component
public class OrderService {
    // 生成订单
    public void generate(){
        System.out.println("正在生成订单");
    }
    // 取消订单
    public void cancel(){
        System.out.println("正在取消订单");
    }
}
