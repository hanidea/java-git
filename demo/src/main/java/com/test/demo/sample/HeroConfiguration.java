package com.test.demo.sample;

import com.test.demo.sample.condition.DianaCondition;
import com.test.demo.sample.condition.IreliaCondition;
import com.test.demo.sample.hero.Camille;
import com.test.demo.sample.hero.Diana;
import com.test.demo.sample.hero.Irelia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    //@Bean
//    public ISkill camille() {
//        return new Camille("Camille",18);
//    }
    //@Conditional(DianaCondition.class)
    //@ConditionalOnProperty(value = "hero.condition",havingValue="diana",matchIfMissing = true)
    public ISkill diana() {
        return new Diana("Diana",18);
    }
    @Bean
    //@Conditional(IreliaCondition.class)
    //@ConditionalOnProperty(value = "hero.condition",havingValue="irelia")
    public ISkill irelia() {
        return new Irelia();
    }
}
