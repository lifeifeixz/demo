package com.baixiang.chuxing.user.model.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by flysLi on 2017/8/15.
 * 三方库
 */
@Repository
@Entity
@Table(name = "activity_user")
public class ActivityUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "mobile")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
