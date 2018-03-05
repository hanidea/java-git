package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Demo,Integer> {
    //通过年龄来查询
    public List<Demo> findByAge(Integer age);
}
