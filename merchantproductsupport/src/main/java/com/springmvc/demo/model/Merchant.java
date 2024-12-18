package com.springmvc.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
////@JsonInclude(JsonInclude.Include.NON_DEFAULT) Purpose: It excludes fields that have their default value
//(e.g., 0 for int, false for boolean, null for objects, etc.) from being serialized into JSON.
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accountNumber;
    private int age;
    private String merchantUsername;
    private String mobNo;
    private String email;
    private String password;
    private String confirmPassword;
    private String city;
    private String state;
    private int pin;

    public Merchant(String merchantUsername, String email) {
        this.merchantUsername = merchantUsername;
        this.email = email;
    }
}
