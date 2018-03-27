package com.wdx.grpc.spring.schema;

import com.wdx.grpc.spring.ServiceBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class GRPCNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {

        //配置<grpc:port>标签解析器
        registerBeanDefinitionParser("port",new GRPCBeanDefinitionParser());
        //配置<grpc:service>标签解析器
        registerBeanDefinitionParser("service",new GRPCBeanDefinitionParser());

    }
}
