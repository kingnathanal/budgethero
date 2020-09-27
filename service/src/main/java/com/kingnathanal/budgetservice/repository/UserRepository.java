package com.hyyercode.kingnathanal.budgetservice.repository;

import com.hyyercode.kingnathanal.budgetservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
