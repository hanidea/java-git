package com.example.demo.sample;

import com.example.demo.sample.condition.DianaCondition;
import com.example.demo.sample.condition.IreliaCondition;
import com.example.demo.sample.hero.Camille;
import com.example.demo.sample.hero.Diana;
import com.example.demo.sample.hero.Irelia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    //@Bean
    //@ConditionalOnProperty(value = "hero.condition",havingValue = "diana",matchIfMissing = true)
    //@Conditional(DianaCondition.class)
//    @ConditionalOnBean(name="mysql")
//    public ISkill diana(){
//        return new Diana("Diana",40);
//    }
    //@ConditionalOnProperty(value = "hero.condition",havingValue = "irelia")
    //@Conditional(IreliaCondition.class)
    @Bean
    public ISkill irelia(){
        return new Irelia();
    }
//    @Bean
//    public ISkill camille(){
//        return new Camille("Camille",18);
//    }
}
