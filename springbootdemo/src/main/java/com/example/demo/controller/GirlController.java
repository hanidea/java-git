package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Demo;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import javafx.beans.binding.Binding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Demo> girlList()
    {
        logger.info("2girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个数据
     * @return
     */
//    @PostMapping(value = "girls")
//    public Demo girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
//        Demo girl = new Demo();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }
    @PostMapping(value = "girls")
    public Demo girlAdd(@Valid Demo girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    //查询一条数据
    @GetMapping(value = "/girls/{id}")
    public Optional<Demo> girlFindOne(@PathVariable("id") Integer id) {

        //直接用findById查找
        return  girlRepository.findById(id);

        //构通Example查找Optional<Demo>
//        Demo girl = new Demo();
//        girl.setId(id);
//        Example<Demo> example = Example.of(girl);
//        return girlRepository.findOne(example);
    }
    //更新
    @PutMapping(value = "/girls/{id}")
    public Demo girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age)
    {
        Demo girl = new Demo();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Demo> girlListByAge(@PathVariable("age") Integer age) {

        //直接用findByage查找
        return girlRepository.findByAge(age);
    }
    //事务管理
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
