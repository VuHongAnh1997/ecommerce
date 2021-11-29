package com.diepvusinhtu1.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "galery")
public class Galery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String thumbnail;

    public Galery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
