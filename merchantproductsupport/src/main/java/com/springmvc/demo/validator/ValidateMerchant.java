package com.springmvc.demo.validator;

import com.springmvc.demo.model.Merchant;

public class ValidateMerchant {

    public boolean validate(Merchant merchant){
        return merchant.getPassword().equals(merchant.getConfirmPassword());
    }
}
