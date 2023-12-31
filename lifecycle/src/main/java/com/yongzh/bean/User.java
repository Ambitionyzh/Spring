package com.yongzh.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author yongzh
 * @version 1.0
 * @description: Bean的生命周期按照粗路的五步的话
 * 第一步：例化Bean(调用无参数构造方法。)
 * 第二步：给Bean属性赋值（调用set方法。）
 * 第三步：始化Bean(会调Bean的init方法。注意：这个init方法需要自己写，自己配。)
 * 第四步：使用Bean
 * 第五步：销Bean(会调Bean的destroy方法。注意：这个destory方法需要自己写，自已配）
 * @date 2023/12/31 10:37
 */
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware , InitializingBean ,DisposableBean{

    private String name;

    public void setName(String name) {
        System.out.println("给对象的属性赋值");
        this.name = name;
    }

    public User(){
        System.out.println("无参构造方法执行");
    }
    public void initBean(){
        System.out.println("初始化bean");
    }
    public void destroyBean(){
        System.out.println("销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean的类加载器是"+classLoader);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean的名字是"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet方法执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 的 destroy方法执行");

    }
}
