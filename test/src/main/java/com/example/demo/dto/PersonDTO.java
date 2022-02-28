package com.example.demo.dto;

import com.example.demo.dto.Validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
//@AllArgsConstructor
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
@PasswordEqual(min=1, message="两次密码不相同")
public class PersonDTO {
    //@NonNull
    @Length(min=2,max=10,message="xxx")
    private String name;
    private Integer age;
//    @Valid
//    private SchoolDTO schoolDTO;
    private String password1;
    private String password2;


}
