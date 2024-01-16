package com.yongzh.bank.service.impl;

import com.yongzh.bank.dao.AccountDao;
import com.yongzh.bank.pojo.Account;
import com.yongzh.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/16 0:03
 */
@Service
public class AccountServiceImpl2 implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act) {
        accountDao.insert(act);
        String s = null;
        s.toString();
    }
}
