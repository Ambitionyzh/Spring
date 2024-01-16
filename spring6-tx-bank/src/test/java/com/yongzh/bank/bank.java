package com.yongzh.bank;



import com.yongzh.bank.pojo.Account;
import com.yongzh.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 22:11
 */

public class bank {
    @Test
    public void testNoXml(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testTransfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testPropagation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        Account account = new Account("act-003",10000);
        accountService.save(account);
    }
}
