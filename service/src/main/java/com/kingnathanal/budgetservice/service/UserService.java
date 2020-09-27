package com.hyyercode.kingnathanal.budgetservice.service;

import com.hyyercode.kingnathanal.budgetservice.entities.User;
import com.hyyercode.kingnathanal.budgetservice.entities.UserDetail;
import com.hyyercode.kingnathanal.budgetservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(User user){
        UserDetail userDetail = new UserDetail();
        userDetail.setPassword(passwordEncoder().encode(userDetail.getPassword()));
        userRepository.save(user);
    }

    public UserRepository getRepo() {
        return this.repo;
    }
}
