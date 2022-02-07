package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.exception.http.ForbiddenException;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.sample.IConnect;
import com.example.demo.sample.ISkill;
import com.example.demo.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    //@Qualifier("irelia")
    private ISkill iSkill;
    //@Autowired
    //private IConnect iConnect;
    //RestFul API
    @Autowired
    private BannerService bannerservice;
    @GetMapping("/test")
    public String test() throws Exception{
        iSkill.r();
        //throw new NotFoundException(10001);
        throw new ForbiddenException(10001);
        //return "Hello,James";
    }
//    @GetMapping("/test1")
//    public void test1(){
//        //iConnect.connect();
//    }
}
