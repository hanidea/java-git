package com.example.demo;

import com.example.demo.sample.EnableLOLConfiguration;
import com.example.demo.sample.HeroConfiguration;
import com.example.demo.sample.ISkill;
import com.example.demo.sample.LOLConfigurationSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan
//@Import(HeroConfiguration.class)
//@Import(LOLConfigurationSelector.class)
@EnableLOLConfiguration
public class LOLApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(LOLApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        ISkill iSkill = (ISkill)context.getBean("irelia");
        iSkill.r();
    }
}
