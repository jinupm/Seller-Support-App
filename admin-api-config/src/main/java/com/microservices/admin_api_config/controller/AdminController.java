package com.microservices.admin_api_config.controller;

import com.microservices.admin_api_config.model.Merchant;
import com.microservices.admin_api_config.model.Product;
import com.microservices.admin_api_config.service.AdminPortalConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminPortalConsumerService adminPortalConsumer;


    @GetMapping("getMerchantByMobNo/{mobNum}")
    public ResponseEntity<Merchant> getMerchantByMobNo(@PathVariable String mobNum) {
        Merchant merchant = adminPortalConsumer.getMerchantByMobNo(mobNum);
        return new  ResponseEntity<>(merchant, HttpStatus.OK);
    }

    @PostMapping("product/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product registeredProduct = adminPortalConsumer.saveProduct(product);
        return new ResponseEntity<>(registeredProduct,HttpStatus.OK);
    }
}
