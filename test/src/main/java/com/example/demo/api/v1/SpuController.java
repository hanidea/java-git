package com.example.demo.api.v1;

import com.example.demo.Service.BannerService;
import com.example.demo.Service.SpuService;
import com.example.demo.dto.PersonDTO;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Banner;
import com.example.demo.model.Spu;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {
    @Autowired
    private SpuService spuservice;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = this.spuservice.getSpu(id);
    }
}
