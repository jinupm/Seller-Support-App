package com.microservices.admin_api_config.model;

import lombok.Data;

@Data
public class Product {


    private int productId;
    private String productName;
    private String accountNumber;
    private String productCategory;
    private String productCode;
    private double price;
}
