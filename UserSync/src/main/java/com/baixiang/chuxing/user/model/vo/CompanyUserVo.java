package com.baixiang.chuxing.user.model.vo;

import com.baixiang.chuxing.user.model.mongo.User;

/**
 * Created by flysLi on 2017/5/26.
 * 企业端请求时返回结果封装的对象
 */
public class CompanyUserVo {

    private String msg;

    private boolean success;

    private User user;

    private UserParamVo userParamVo;

    public void setUserParamVo(UserParamVo userParamVo){this.userParamVo = userParamVo;}

    public UserParamVo getUserParamVo(){return this.userParamVo;}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getStatus() {
        return success;
    }

    public void setStatus(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CompanyUserVo{" +
                "msg='" + msg + '\'' +
                ", status='" + success + '\'' +
                ", user=" + user +
                '}';
    }

    public CompanyUserVo(String msg, boolean status, User user) {
        this.msg = msg;
        this.success = status;
        this.user = user;
    }

    public CompanyUserVo() {
    }
}
