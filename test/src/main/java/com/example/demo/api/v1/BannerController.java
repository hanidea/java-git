package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Autowired
    private Diana diana;
    //RestFul API
    @Autowired
    private BannerService bannerservice;
    @GetMapping("/test")
    public String test(){
        diana.r();
        return "Hello,James";
    }
}
