package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String cupSize;
    private Integer age;
    public String getCupSize(){
        return cupSize;
    }
    public void setCupSize(String cupSize)
    {
        this.cupSize = cupSize;
    }
}
