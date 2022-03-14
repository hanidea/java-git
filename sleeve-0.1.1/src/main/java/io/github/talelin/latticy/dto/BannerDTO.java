package io.github.talelin.latticy.dto;

import io.github.talelin.autoconfigure.validator.Length;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerDTO {

    @NotBlank
    @Length(min = 2, max = 20)
    private String name;

    @Length(min = 2, max = 30)
    private String title;

    @Length(min = 2, max = 256)
    private String img;

    @Length(min = 2, max = 256)
    private String description;

}
