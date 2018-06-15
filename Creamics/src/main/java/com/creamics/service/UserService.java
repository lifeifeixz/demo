package com.creamics.service;

import com.creamics.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by flysLi on 2017/8/17.
 */
@Repository
public interface UserService {
    void save(User user);

    List<User> findAll();

}
