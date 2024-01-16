package com.yongzh.bank.dao;

import com.yongzh.bank.pojo.Account;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 22:04
 */
public interface AccountDao {
    /**
     * 根据账号查询余额
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * @param act
     * @return
     */
    int update(Account act);

    void insert(Account act);

}
