package com.hyyercode.kingnathanal.budgetservice.controller;

import com.hyyercode.kingnathanal.budgetservice.entities.User;
import com.hyyercode.kingnathanal.budgetservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceHomeController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value="/home")
    public String getHome() {
        List<User> users = userRepo.findAll();

        System.out.println(users.size());

        users.forEach(user -> System.out.println(user.getUsername()));

        return "Hello World!";
    }
}
