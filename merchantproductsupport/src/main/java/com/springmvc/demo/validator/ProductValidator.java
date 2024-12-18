package com.springmvc.demo.validator;

import com.springmvc.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class ProductValidator {

    public static boolean isValid(Product product) {
        return product.getProductCategory().equalsIgnoreCase("Electronics");
    }
}

