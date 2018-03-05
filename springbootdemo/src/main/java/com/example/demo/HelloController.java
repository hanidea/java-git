package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;
    @Autowired
    private DemoProperties demoProperties;

    //@RequestMapping(value = "/say" ,method = RequestMethod.GET)
    @GetMapping(value = "/say")
    //public String say(@PathVariable("id")Integer id){
    public String say(@RequestParam(value = "id",required =false,defaultValue = "0") Integer testid){
        return "id:" + testid;
        //return demoProperties.getCupSize();
        //return "index";
    }
}
