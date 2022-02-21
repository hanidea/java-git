package com.example.demo.Service;

import com.example.demo.model.Spu;
import com.example.demo.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuService {
    @Autowired
    SpuRepository spuRepository;
    public Spu getSpu(Long id){
        return this.spuRepository.findOneById(id);
    }
}
