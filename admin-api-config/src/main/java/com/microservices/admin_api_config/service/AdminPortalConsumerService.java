package com.microservices.admin_api_config.service;

import com.microservices.admin_api_config.model.Merchant;
import com.microservices.admin_api_config.model.Product;

import java.util.List;


public interface AdminPortalConsumerService {
    public Merchant getMerchantByMobNo(String mobNum);
    public Product saveProduct(Product product);
}
