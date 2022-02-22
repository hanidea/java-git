package com.example.demo.model;

import com.example.demo.util.ListAndJson;
import com.example.demo.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
//    @Convert(converter = MapAndJson.class)
//    private Map<String, Object> test;
    @Convert(converter = ListAndJson.class)
    private List<Object> specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

}
