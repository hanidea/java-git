package io.github.talelin.latticy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BannerDO {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String img;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
