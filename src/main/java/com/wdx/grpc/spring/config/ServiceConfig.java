package com.wdx.grpc.spring.config;

import io.grpc.BindableService;

import java.util.ArrayList;
import java.util.List;

public class ServiceConfig {

    private static List<BindableService> classList = new ArrayList<BindableService>();

    public static void addClass(BindableService clasz){
        classList.add(clasz);
    }


    public static List<BindableService> getClassList(){
        return classList;
    }
}
