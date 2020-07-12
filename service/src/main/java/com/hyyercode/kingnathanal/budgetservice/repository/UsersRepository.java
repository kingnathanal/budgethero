package com.hyyercode.kingnathanal.budgetservice.repository;

import com.hyyercode.kingnathanal.budgetservice.jpa.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
}
