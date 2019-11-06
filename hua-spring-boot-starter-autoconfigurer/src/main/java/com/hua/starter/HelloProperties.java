package com.hua.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

//需要配置的属性
//在实现了AutoConfigurer后可以将xml中的属性装配到该类(自动装配)
@ConfigurationProperties(prefix = "hua.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
