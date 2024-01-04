package com.yongzh.proxy;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2024/1/4 22:26
 */
public interface OrderService {
    /**
     * 生成订单
     */
    void generate();

    /**
     * 查看订单详情
     */
    void detail();

    /**
     * 修改订单
     */
    void modify();
}
