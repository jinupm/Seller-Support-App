package com.microservices.admin_api_config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
public class Merchant {
    private int id;
    private String accountNumber;
    private String merchantUsername;
    private String mobNo;
    private String email;
    private String password;
    private String confirmPassword;
    private String city;
    private String state;
    private int pin;
}
