package com.example.demo.sample.hero;

import com.example.demo.sample.ISkill;

public class Camille implements ISkill {
    private String name;
    private Integer age;
    public Camille(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public Camille() {
        System.out.println("Hello3,7yue");
    }
    public void q(){
        System.out.println("Camille Q");
    }
    public void w(){
        System.out.println("Camille W");
    }
    public void e(){
        System.out.println("Camille E");
    }
    public void r(){
        System.out.println("Camille R");
    }
}
