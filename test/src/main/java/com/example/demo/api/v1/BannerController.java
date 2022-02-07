package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.sample.IConnect;
import com.example.demo.sample.ISkill;
import com.example.demo.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Autowired
    //@Qualifier("irelia")
    private ISkill iSkill;
    @Autowired
    private IConnect iConnect;
    //RestFul API
    @Autowired
    private BannerService bannerservice;
    @GetMapping("/test")
    public String test(){
        iSkill.r();
        return "Hello,James";
    }
    @GetMapping("/test1")
    public void test1(){
        iConnect.connect();
    }
}
