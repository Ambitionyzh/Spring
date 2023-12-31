package com.yongzh.bean;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 15:16
 */
public class Husband {

    private  String name;
    private Wife wife;

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
