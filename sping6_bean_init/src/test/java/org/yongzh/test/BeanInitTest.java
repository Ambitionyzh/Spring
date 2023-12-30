package org.yongzh.test;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yongzh.bean.Person;
import org.yongzh.simpleFactory.Vip;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/30 11:42
 */

public class BeanInitTest {
    @Test
    public void testFactoryBaen(){
        ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);

        Person personBean2 = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean2);
    }
    @Test
    public void testSimpleFacory(){
        ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
        Vip personBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(personBean);


    }
}

