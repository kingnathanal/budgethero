package com.hyyercode.kingnathanal.budgetservice.controller;

import com.hyyercode.kingnathanal.budgetservice.jpa.Users;
import com.hyyercode.kingnathanal.budgetservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceHomeController {

    @Autowired
    UsersRepository usersRepo;

    @GetMapping(value="/home")
    public String getHome() {
        List<Users> users = usersRepo.findAll();

        System.out.println(users.size());
        return "Hello World!";
    }
}
