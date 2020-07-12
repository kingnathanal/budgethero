package com.hyyercode.kingnathanal.budgetservice;

import com.hyyercode.kingnathanal.budgetservice.jpa.Users;
import com.hyyercode.kingnathanal.budgetservice.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BudgetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetServiceApplication.class, args);
	}

}
