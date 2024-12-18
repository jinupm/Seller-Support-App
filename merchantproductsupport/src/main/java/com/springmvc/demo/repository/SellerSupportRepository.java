/*
package com.springmvc.demo.repository;

import com.springmvc.demo.model.Seller;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SellerSupportRepository {

    private static List<Seller> sellerList;


    @PostConstruct
    private void init() {
        sellerList = new ArrayList<>();
    }


    public void register(Seller seller) {
        sellerList.add(seller);
    }


    public Seller getSellersByMobNo(String mobNo) {
        return sellerList.stream()
                .filter(seller -> seller.getMobNo().equals(mobNo))
                .findFirst()
                .orElse(null);
    }


}
*/
