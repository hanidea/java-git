package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Demo girlA = new Demo();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Demo girlB = new Demo();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Demo girl= girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回上小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
