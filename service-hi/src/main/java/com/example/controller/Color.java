package com.example.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author flysLi
 * @date 2018/2/27
 */
@Entity
@Table(name = "color")
public class Color implements Serializable {

    @Id
    @Column(name = "color", nullable = false, length = 100)
    private String color;

    @Column(name = "level", nullable = false, length = 3)
    private int level;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
