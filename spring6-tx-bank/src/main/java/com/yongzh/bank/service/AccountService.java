package com.yongzh.bank.service;

import com.yongzh.bank.pojo.Account;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 22:08
 */
public interface AccountService {
    void transfer(String fromActno, String toActno, double money);
    void save(Account act);
}
