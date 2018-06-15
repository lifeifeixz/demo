package com.baixiang.chuxing.user.model.vo;

/**
 * Created by flysLi on 2017/5/26.
 * 用于接收企业端传来参数的对象
 */
public class UserParamVo {
    private String name;
    private String idCard;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "UserParamVo{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public UserParamVo(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public UserParamVo() {
    }
}
