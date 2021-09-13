package com.test.demo.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.test.demo.util.GenericAndJson;
import com.test.demo.util.ListAndJson;
import com.test.demo.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
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

    public List<Spec> getSpecs() {
        if(this.specs == null){
            return Collections.emptyList();
        }
        //return GenericAndJson.jsonToList(this.specs, new TypeReference<List<Spec>>() {
        //});
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {
        });
//        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        if(specs.isEmpty()){
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
    //    @Convert(converter = MapAndJson.class)
//    private Map<String,Object> test;
    //@Convert(converter = ListAndJson.class)
    private String specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

//    public List<Spec> getSpecs(){
//        String specs = this.specs;
//        return List<Spec>
//    }
//    public void setSpecs(List<Spec> data){
//
//    }


}
