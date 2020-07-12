package com.hyyercode.kingnathanal.budgetservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(mappedBy = "userDetail")
    private User user;
}
