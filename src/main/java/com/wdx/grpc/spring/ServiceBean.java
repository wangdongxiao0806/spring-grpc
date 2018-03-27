package com.wdx.grpc.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class ServiceBean implements InitializingBean ,BeanNameAware{


    private String beanName;

    public void afterPropertiesSet() throws Exception {
            //此处可以进行实体类的初始化前工作
        System.out.println("bean "+this.beanName+" init()");
    }

    public void setBeanName(String name) {
        this.beanName = name;
    }
}
