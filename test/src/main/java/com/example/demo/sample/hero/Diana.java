package com.example.demo.sample.hero;

import com.example.demo.sample.ISkill;
import org.springframework.stereotype.Component;

@Component
public class Diana implements ISkill {
    public Diana() {
        System.out.println("Hello,7yue");
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
