package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@Where(clause = "delete_time is null and online = 1")
public class Activity extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private String remark;
    private Boolean online;
    private String entranceImg;
    private String internalTopImg;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="activityId")
    private List<Coupon> couponList;

}
