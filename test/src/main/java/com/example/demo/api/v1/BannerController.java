package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.core.interceptors.ScopeLevel;
import com.example.demo.dto.PersonDTO;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Banner;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

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
    @ScopeLevel()
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = bannerservice.getByName(name);
        if(banner == null){
            throw new NotFoundException(30005);
        }
        return banner;
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
