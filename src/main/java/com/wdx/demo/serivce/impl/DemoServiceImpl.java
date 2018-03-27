package com.wdx.demo.serivce.impl;

import com.wdx.demo.serivce.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
