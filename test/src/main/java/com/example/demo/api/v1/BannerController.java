package com.example.demo.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    //RestFul API
    @GetMapping("/test")
    public String test(){
        return "Hello,James";
    }
}
