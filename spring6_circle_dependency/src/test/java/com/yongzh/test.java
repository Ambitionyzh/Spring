package com.yongzh;


import com.yongzh.bean.Husband;
import com.yongzh.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yongzh
 * @version 1.0
 * @description: singleton+setter机式下的循环依模是没有任何阿题的.
 * singleton表示在整个Spring容器当中是单例的，独一无二的对象。
 * 在singleton+setter使式下，为什么循环依赖不会出现间愿，Spring是如何应对的？
 * 主要的原因是，在这种模式下Spring对Bean的管理主要分为清晰的两个阶段：
 * 第一个阶段：在Spring容器加载的时候，实例化Bean,只要其中任意一个Bean实例化之后，马上进行“曝光"【不等属性赋值就曝光】
 * 第二个阶段：Bean“曝光"之后，再进行属性的赋值（调用set方法。）
 * 核心解决方案是：实例化对象和对象的属性赋值分为两个阶段来完成的
 * @date 2023/12/31 15:22
 */
public class test {
    @Test
    public void circleDependency(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);

    }
}
