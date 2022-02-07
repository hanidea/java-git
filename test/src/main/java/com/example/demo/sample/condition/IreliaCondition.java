package com.example.demo.sample.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IreliaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String name = conditionContext.getEnvironment().getProperty("hero.condition");
        return "irelia".equalsIgnoreCase(name);
    }
}