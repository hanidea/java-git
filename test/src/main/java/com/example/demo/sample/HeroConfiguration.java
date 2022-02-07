package com.example.demo.sample;

import com.example.demo.sample.condition.DianaCondition;
import com.example.demo.sample.condition.IreliaCondition;
import com.example.demo.sample.hero.Camille;
import com.example.demo.sample.hero.Diana;
import com.example.demo.sample.hero.Irelia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Bean
    @Conditional(DianaCondition.class)
    public ISkill diana(){
        return new Diana("Diana",40);
    }
    @Bean
    @Conditional(IreliaCondition.class)
    public ISkill irelia(){
        return new Irelia();
    }
//    @Bean
//    public ISkill camille(){
//        return new Camille("Camille",18);
//    }
}
