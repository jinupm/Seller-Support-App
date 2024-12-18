package com.springmvc.demo.service;

import com.springmvc.demo.exception.InvalidProductException;
import com.springmvc.demo.exception.UserNotFoundException;
import com.springmvc.demo.model.Merchant;
import com.springmvc.demo.model.MerchantProductReq;
import com.springmvc.demo.model.MerchantProductRes;
import com.springmvc.demo.model.Product;
import com.springmvc.demo.repository.MerchantRepository;
/*
import com.springmvc.demo.repository.MerchantSupportRepository;
*/
import com.springmvc.demo.repository.ProductRepository;
import com.springmvc.demo.validator.ProductValidator;
import com.springmvc.demo.validator.ValidateMerchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

/*    @Autowired
    private MerchantSupportRepository merchantSupportRepository;*/

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ProductRepository userRepository;

    @Autowired
    private ValidateMerchant validateMerchant;

    @Autowired
    private ProductValidator productValidator;


/*    @Override
    public Merchant register(Merchant merchant) {

        if(validateMerchant.validate(merchant)) {
            merchantSupportRepository.register(merchant);
            return "Your Merchant Details are registered " + merchant.getProductname();
        }else{
            return "The passwords do not match";
        }
    }*/



    @Override
    public Merchant register(Merchant merchant) {
        merchant.setAccountNumber(generateRandomAccountNo());
        return merchantRepository.save(merchant);
    }


    @Override
    public List<Merchant> saveAllMerchants(List<Merchant> merchantList) {

//        for (Merchant merchant : merchantList) {
//            merchant.setAccountNumber(generateAccountNumber());
//        }

        merchantList.parallelStream().forEach(merchant -> {merchant.setAccountNumber(generateRandomAccountNo());});
        List<Merchant> merchant = merchantRepository.saveAll(merchantList);
        return merchant;
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }


    private String generateRandomAccountNo(){
        return String.valueOf(Math.random()).substring(2);
    }

    @Override
    public Merchant findMerchantById(int id){
        return merchantRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteMerchantById(int id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public Merchant getMerchantsByMobNum(String mobNo) {
        return merchantRepository.getMerchantByMobNum(mobNo);
    }

    @Override
    public List<Object[]> getNameAndStateByMobNo(String mobNo) {
        return merchantRepository.getNameAndStateByMobNo(mobNo);
    }

    @Override
    public Merchant getNameAndEmailByMobNo(String mobNo) {
        return merchantRepository.getNameAndEmailByMobNo( mobNo);
    }

    @Override
    public MerchantProductRes saveMerchantAndProduct(MerchantProductReq merchantProductReq) {

        Merchant merchant = merchantProductReq.getMerchant();
        Product product = merchantProductReq.getProduct();


        merchant.setAccountNumber(generateRandomAccountNo());
        merchantRepository.save(merchant);


        if(ProductValidator.isValid(product)){
            product.setAccountNumber(generateRandomAccountNo());
            userRepository.save(product);
        } else{
            throw new InvalidProductException("Invalid user name , Please enter registered username" );
        }


        return MerchantProductRes.builder()
                .merchantUsername(merchant.getMerchantUsername())
                .productName(product.getProductName()).build();
    }

    @Override
    public Merchant findMerchantByUsername(String username) {
        return merchantRepository.findMerchantByMerchantUsername(username);
    }
}
