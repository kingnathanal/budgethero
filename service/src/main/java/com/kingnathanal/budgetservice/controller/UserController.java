package com.hyyercode.kingnathanal.budgetservice.controller;

import com.hyyercode.kingnathanal.budgetservice.entities.User;
import com.hyyercode.kingnathanal.budgetservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getRepo().findAll();
    }
}
