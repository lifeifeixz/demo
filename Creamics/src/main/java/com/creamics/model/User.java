package com.creamics.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by flysLi on 2017/8/17.
 */
public class User {

    @Id
    private Integer id;

    private String name;

    private Date birdthdy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirdthdy() {
        return birdthdy;
    }

    public void setBirdthdy(Date birdthdy) {
        this.birdthdy = birdthdy;
    }
}
