package com.example.demo;

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
        girlB.setCupSize("BBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }
}
