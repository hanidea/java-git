package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.dto.PersonDTO;
import com.example.demo.exception.http.ForbiddenException;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.sample.IConnect;
import com.example.demo.sample.ISkill;
import com.example.demo.sample.hero.Diana;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.util.Map;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {
    //@Autowired
    //@Qualifier("irelia")
    //private ISkill iSkill;
    //@Autowired
    //private IConnect iConnect;
    //RestFul API
    @Autowired
    private BannerService bannerservice;

    @GetMapping("/name/{name}")
    public void getByName(@PathVariable String name) {

    }


    @PostMapping("/test/{id}")
    public PersonDTO test(@PathVariable @Range(min=1,max=10, message = "不可以超过10哦") Integer id, @RequestParam @Length(min=8) String name, @RequestBody @Validated PersonDTO person) throws Exception {
        //iSkill.r();
//        PersonDTO dto = new PersonDTO();
//        dto.setName("123");
//        dto.setAge(7);
        PersonDTO dto = PersonDTO.builder()
                .name("James")
                .age(18)
                .build();
        return dto;
        //throw new ForbiddenException(10000);
    }
//    @GetMapping("/test1")
//    public void test1(){
//        //iConnect.connect();
//    }
}
