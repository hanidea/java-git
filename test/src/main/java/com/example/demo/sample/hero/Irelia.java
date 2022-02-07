package com.example.demo.sample.hero;

import com.example.demo.sample.ISkill;
import org.springframework.stereotype.Component;

//@Component
public class Irelia implements ISkill {
    public Irelia() {
        System.out.println("Hello2,7yue");
    }
    public void q(){
        System.out.println("Irelia Q");
    }
    public void w(){
        System.out.println("Irelia W");
    }
    public void e(){
        System.out.println("Irelia E");
    }
    public void r(){
        System.out.println("Irelia R");
    }
}
