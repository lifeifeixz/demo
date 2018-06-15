package com.creamics.service.impl;

import com.creamics.dao.UserRepository;
import com.creamics.model.User;
import com.creamics.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by flysLi on 2017/8/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    public void save(User user) {

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
