package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
