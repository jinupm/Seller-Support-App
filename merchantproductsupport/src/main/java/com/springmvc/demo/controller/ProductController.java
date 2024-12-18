package com.springmvc.demo.controller;

import com.springmvc.demo.model.Product;
import com.springmvc.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Product> register(@RequestBody Product product){
        Product registerdProduct = productService.saveProduct(product);
        return new ResponseEntity<>(registerdProduct, HttpStatus.OK);
    }

    @PostMapping("/register-products")
    public ResponseEntity<List<Product>> registerProducts(@RequestBody List<Product> productList){
        List<Product> savedList = productService.saveAllProducts(productList);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
