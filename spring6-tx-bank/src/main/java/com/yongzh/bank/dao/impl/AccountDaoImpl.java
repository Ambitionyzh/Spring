package com.yongzh.bank.dao.impl;

import com.yongzh.bank.dao.AccountDao;
import com.yongzh.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 22:06
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select actno, balance from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int update(Account act) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql, act.getBalance(), act.getActno());
        return count;
    }


    @Override
    public void insert(Account act) {
        String sql = "insert into t_act values(?,?)";
        jdbcTemplate.update(sql,act.getActno(),act.getBalance());

    }
}
