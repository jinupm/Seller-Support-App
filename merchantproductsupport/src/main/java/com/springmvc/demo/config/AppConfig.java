package com.springmvc.demo.config;

import com.springmvc.demo.validator.ValidateMerchant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ValidateMerchant getValidatorObj(){
        return  new ValidateMerchant();
    }
}
