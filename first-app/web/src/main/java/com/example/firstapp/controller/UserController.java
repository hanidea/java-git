package com.example.firstapp.controller;

import com.example.firstapp.domain.User;
import com.example.firstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象:%s 保存成功！\n",user);
        };
        return user;
    }
}
