package com.zfq.rbac.controller;

import com.zfq.rbac.mapper.UserMapper;
import com.zfq.rbac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{id}")
    public void findUserBtId(@PathVariable("id") Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println(user);
    }

    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login";
    }
}


