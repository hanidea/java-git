package com.test.demo.dto;

import com.test.demo.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

@Getter
//@Setter
//@Data
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
@PasswordEqual(min=1,message = "两次密码不相同")
public class PersonDTO {
    //final private String t;
    //@NonNull
    @Length(min=2, max=10, message="长度大于2小于10")
    private String name;
    private Integer age;

    private String password1;
    private String password2;

//    @Valid
//    private SchoolDTO schoolDTO;
}
