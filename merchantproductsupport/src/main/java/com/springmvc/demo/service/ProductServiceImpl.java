package com.springmvc.demo.service;

import com.springmvc.demo.model.Product;
import com.springmvc.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        product.setAccountNumber(generateRandomAccountNo());
        return productRepository.save(product);
    }

    private String generateRandomAccountNo(){
        return String.valueOf(Math.random()).substring(2);
    }

    @Override
    public List<Product> saveAllProducts(List<Product> productList) {

        productList.parallelStream().forEach(product -> product.setAccountNumber(generateRandomAccountNo()));
        return productRepository.saveAll(productList);
    }


}
