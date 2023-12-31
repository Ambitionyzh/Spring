package com.yongzh.bean;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 15:16
 */
public class Wife {
    private  String name;
    private Husband husband;

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
