package com.example.demo.sample;

import com.example.demo.sample.hero.Camille;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Bean
    public ISkill camille(){
        return new Camille("Camille",18);
    }
}
