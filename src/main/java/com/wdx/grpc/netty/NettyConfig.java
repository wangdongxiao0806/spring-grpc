package com.wdx.grpc.netty;

import com.wdx.grpc.spring.config.ServiceConfig;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

public class NettyConfig implements InitializingBean, BeanNameAware{

    private  int port;

    private  Server server;

    public void setBeanName(String name) {
        this.port = Integer.valueOf(name.substring(11));
    }

    public void afterPropertiesSet() throws Exception {

    }
    public  void start() throws IOException {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        for(BindableService clasz : ServiceConfig.getClassList()){
            serverBuilder = serverBuilder.addService(clasz);
        }
        server = serverBuilder.build().start();
    }
}
