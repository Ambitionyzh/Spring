package org.yongzh.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.yongzh.bean.Person;

/**
 * @author yongzh
 * @version 1.0
 * @description: 通过FactoryBean接口实例化bean
 * @date 2023/12/30 11:38
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
