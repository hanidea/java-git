package com.example.demo.Service;

import com.example.demo.model.Spu;
import com.example.demo.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    SpuRepository spuRepository;
    public Spu getSpu(Long id){
        return this.spuRepository.findOneById(id);
    }
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }
    public Page<Spu> getByCategory(Long cid,Boolean isRoot, Integer pageNum, Integer size){
        Pageable page = PageRequest.of(pageNum,size);
        //Page<Spu> spuPage = null;
        if(isRoot){
            return this.spuRepository.findByRootCategoryIdOrderByCreateTime(cid,page);
        }
        else{
            return this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid,page);
        }

    }
}


