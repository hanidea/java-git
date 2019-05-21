package com.bighanhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(int age){
        return "age:"+age;
    }
}
