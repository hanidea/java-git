package com.example.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //logger.info("0before");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        //System.out.println(7878);
        logger.info("1after");
    }
    @AfterReturning(returning ="object", pointcut ="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());

    }
}
