package com.example.demo.api.v1;

import com.example.demo.Service.WxAuthenticationService;
import com.example.demo.dto.TokenDTO;
import com.example.demo.dto.TokenGetDTO;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "token")
@RestController
public class TokenController {
    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String,String> getToken(@RequestBody @Validated TokenGetDTO userData){
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (userData.getType()) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_Email:
                break;
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody TokenDTO token) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean valid = JwtToken.verifyToken(token.getToken());
        map.put("is_valid", valid);
        return map;
    }
}
