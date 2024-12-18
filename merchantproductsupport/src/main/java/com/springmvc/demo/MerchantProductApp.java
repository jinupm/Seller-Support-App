package com.springmvc.demo;

import com.springmvc.demo.util.Utility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//This annotation is combination of 3 annotations @EnableAutoConfiguration , @ ComponentScan , @Configuration
public class MerchantProductApp {

public static void main(String[] args) {

		//springApplication.run returns ApplicationContext .
		ApplicationContext context = SpringApplication.run(MerchantProductApp.class, args);
		Utility utility = context.getBean("utility",Utility.class);
		utility.util();

	}

}
