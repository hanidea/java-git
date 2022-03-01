package com.example.demo.dto;

import com.example.demo.core.enumeration.LoginType;
import com.example.demo.dto.Validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "account不允许为空")
    private String account;
    @TokenPassword(min=6,max=30,message="{token.password}")
    private String password;
    private LoginType type;
}
