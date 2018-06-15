package com.creamics.Controller;

import com.creamics.dao.UserRepository;
import com.creamics.model.User;
import com.creamics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by flysLi on 2017/8/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "find")
    public List<User> find() {

        return userService.findAll();
    }
}
