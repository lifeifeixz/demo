package com.example.db.service;

import com.example.db.bean.User;

/**
 * @author flysLi
 * @date 2018/6/15
 */
public interface UserService {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return 完整的用户对象
     */
    User findById(int id);
}
