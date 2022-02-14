package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banner1")
public class Banner {
    @Id
    private long id;
    @Column(length = 16)
    private String name;
    private String description;
    private String img;
    private String title;

}
