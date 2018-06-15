package com.example.db.controller;

import com.example.db.bean.User;
import com.example.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flysLi
 * @date 2018/6/15
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }
}
