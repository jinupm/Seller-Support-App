package com.springmvc.demo.service;

import com.springmvc.demo.model.Merchant;
import com.springmvc.demo.model.MerchantProductReq;
import com.springmvc.demo.model.MerchantProductRes;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    public Merchant register(Merchant merchant);
    public List<Merchant> saveAllMerchants(List<Merchant> merchantList);
    public List<Merchant> findAll();
    public Merchant findMerchantById(int id);
    public void deleteMerchantById(int id);
    public Merchant findMerchantByUsername(String username);
    public Merchant getMerchantsByMobNum(String mobNo);


    public List<Object[]> getNameAndStateByMobNo(String mobNo);
    public Merchant getNameAndEmailByMobNo(String mobNo);

    public MerchantProductRes saveMerchantAndProduct(MerchantProductReq merchantProductReq);


}
