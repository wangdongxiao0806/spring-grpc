package com.wdx.grpc.spring.schema;

import com.wdx.demo.serivce.impl.DemoServiceImpl;
import com.wdx.grpc.netty.NettyConfig;
import com.wdx.grpc.spring.config.ServiceConfig;
import io.grpc.BindableService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 标签解析器
 */
public class GRPCBeanDefinitionParser  implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        String tagName = element.getTagName();
        String id = element.getAttribute("id");
        if("grpc:service".equals(tagName)) {
            String elementClass = element.getAttribute("class");
            BindableService service  = null;
            try {
                beanDefinition.setBeanClass(Class.forName(elementClass));
                service = (BindableService)Class.forName(elementClass).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            ServiceConfig.addClass(service);

        }else if("grpc:port".equals(tagName)){
            String port  = element.getAttribute("port");
            if(StringUtils.isEmpty(id)){
                id="nettyConfig"+port;
            }
            beanDefinition.setBeanClass(NettyConfig.class);
        }

        parserContext.getRegistry().registerBeanDefinition(id,beanDefinition);
        return beanDefinition;
    }
}
