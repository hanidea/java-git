package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BannerItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String img;
    private String keyword;
    private String type;
    private String name;

    private Long bannerId;
    @ManyToOne
    @JoinColumn(insertable = false,updatable=false, name="bannerId")
    private Banner banner;

}
