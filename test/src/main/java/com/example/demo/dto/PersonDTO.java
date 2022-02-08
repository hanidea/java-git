package com.example.demo.dto;

import lombok.*;

@Getter
//@AllArgsConstructor
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
public class PersonDTO {
    //@NonNull
    private String name;
    private Integer age;
}
