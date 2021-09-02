package com.test.demo.sample.hero;

import com.test.demo.sample.ISkill;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component

//@Lazy
public class Diana implements ISkill {
    private String skillName = "Diana D";
    private String name;
    private Integer age;
    public Diana (String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public Diana(){
        System.out.println("Hello,junjie");
    }
    public void q(){
        System.out.println("Diana Q");
    }
    public void w(){
        System.out.println("Diana W");
    }
    public void e(){
        System.out.println("Diana E");
    }
    public void r(){
        System.out.println("Diana R");
    }
}
