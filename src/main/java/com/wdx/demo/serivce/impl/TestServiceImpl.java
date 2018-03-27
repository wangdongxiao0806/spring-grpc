package com.wdx.demo.serivce.impl;

import com.wdx.demo.serivce.TestService;

public class TestServiceImpl implements TestService {
    public String sayHi(String name) {
        return "Hi "+name;
    }
}
