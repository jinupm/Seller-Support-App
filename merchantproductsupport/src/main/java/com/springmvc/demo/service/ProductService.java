package com.springmvc.demo.service;

import com.springmvc.demo.model.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    public List<Product> saveAllProducts(List<Product> productList);

    public Product saveProduct(Product product);
}
