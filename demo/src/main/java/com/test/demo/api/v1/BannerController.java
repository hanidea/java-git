package com.test.demo.api.v1;

import com.test.demo.dto.PersonDTO;
import com.test.demo.exception.http.NotFoundException;
import com.test.demo.model.Banner;
import com.test.demo.sample.IConnect;
import com.test.demo.service.BannerServiceImpl;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
//@Lazy
@RequestMapping("/banner")
@Validated
public class BannerController {

    //@Autowired
    //@Qualifier("irelia")
    //private ISkill iSkill;
    @Autowired
    private IConnect iConnect;
    @Autowired
    private BannerServiceImpl bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name){
        Banner banner = bannerService.getByName(name);
        if(banner == null){
            throw new NotFoundException(30005);
        }
        return banner;
    }
    //RestFul API
    //host:port/v1/banner
    //header
    //version:v1
    //url?version = v1
    @PostMapping("/test/{id}")
    public PersonDTO test(@PathVariable @Range(min=1,max=10,message = "不可以超过10个") Integer id, @RequestParam String name, @RequestBody @Validated PersonDTO person) throws Exception {
        //iSkill.r();
//        PersonDTO dto = new PersonDTO();
//        dto.setName("James");
//        dto.setAge(7);
          PersonDTO dto = PersonDTO.builder()
                  .name("James")
                  .age(18)
                  .build();
        //throw new ForbiddenException(10001);
        //throw new RuntimeException("这里错了");
        return dto;
    }
//    @GetMapping("/test1")
//    public void test1(){
//        iConnect.connect();
//    }
}
