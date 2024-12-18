package com.springmvc.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;


    private String userName;
    private long mobNo;
    private String email;
    private String password;
    private String confirmPassword;
    private String accountNumber;
    private String productCategory;
}
