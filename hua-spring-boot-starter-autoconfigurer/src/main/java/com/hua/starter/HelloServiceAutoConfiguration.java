package com.hua.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//配置类
@ConditionalOnWebApplication//Web应用才生效
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    //添加service到容器中
    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}

//1.Properties:需要配置的属性,@ConfigurationProperties(prefix="配置文件中的前缀")
////在实现了AutoConfiguration后可以将使用starter的项目的xml中的属性装配到该类(自动装配)
//2.Service:需要被添加到容器中的Bean,域中引入Properties,设置getter和setter方法
//3.AutoConfiguration:自动配置类,@Configuration @ConditionalOn**(什么情况下自动配置生效) @EnableConfigurationProperties(**Properties.class)
//域中引入@Autowired Properties,添加一个返回**Service的方法,**Service中设置**Properties的值(这样**Service中就有我自动装配进来的**Properties了,就可以取其中的值)
//4.META-INF下创建spring.factories,导入**AutoConfiguration