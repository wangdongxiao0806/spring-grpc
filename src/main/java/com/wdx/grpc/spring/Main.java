package com.wdx.grpc.spring;

import com.wdx.demo.serivce.DemoService;
import com.wdx.demo.serivce.TestService;
import com.wdx.grpc.netty.NettyConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-grpc/spring-grpc.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        String result =demoService.sayHello("wdx");
        System.out.println(result);
        TestService testService = (TestService) context.getBean("testService");
        String result1 =testService.sayHi("wdx");
        System.out.println(result1);
        System.in.read(); // 按任意键退出
    }
}
