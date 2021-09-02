package com.test.demo.sample.hero;

import com.test.demo.sample.ISkill;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class Irelia implements ISkill {
    public Irelia(){
        System.out.println("Hello,junjie");
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
