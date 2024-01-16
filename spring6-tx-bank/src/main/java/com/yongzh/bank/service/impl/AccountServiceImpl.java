package com.yongzh.bank.service.impl;

import com.yongzh.bank.dao.AccountDao;
import com.yongzh.bank.pojo.Account;
import com.yongzh.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 22:09
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        // 查询账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("账户余额不足");
        }
        // 余额充足，开始转账
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.update(fromAct);
     /*   String s = null;
        s.toString();*/
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行");
        }
    }

    @Resource(name = "accountServiceImpl2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {
        // 这里调用dao的insert方法。
        accountDao.insert(act); // 保存act-003账户

        // 创建账户对象
        Account act2 = new Account("act-004", 10000.0);
        try {
            accountService.save(act2); // 保存act-004账户
        } catch (Exception e) {

        }
        // 继续往后进行我当前1号事务自己的事儿。
    }
}
