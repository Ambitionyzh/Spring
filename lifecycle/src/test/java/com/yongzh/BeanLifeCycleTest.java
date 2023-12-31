package com.yongzh;

import com.yongzh.bean.Student;
import com.yongzh.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 10:43
 */
public class BeanLifeCycleTest {

    @Test
    public void testRegisterBean(){
        Student student = new Student();
        System.out.println(student);

        //
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);

    }



    /** 
     * @description: Spring容器只singleton的Bean进行完整的生命周期管理
     * 如果是prototype作用域的Bean,Spring容器具负责将该Bean始化完毕。
     * 等客户端程序一旦获取到Bean,之后，Spring容器就不再管理该对象的生命周期了
     */ 
    @Test
    public void testBeanLifeCycleFive(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println("第四步：使用bean"+userBean);
        //必须手动关闭Spring容器，这样Spring容器才会销毁bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();

    }
}
