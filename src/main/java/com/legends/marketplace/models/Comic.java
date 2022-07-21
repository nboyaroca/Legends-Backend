package com.legends.marketplace.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comics")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String img;
    private String name;
    private String condition;
    private String price;


}
