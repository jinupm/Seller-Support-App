package com.springmvc.demo.repository;

import com.springmvc.demo.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    public Merchant findMerchantByMerchantUsername(String merchantUsername);

    @Query("SELECT m FROM Merchant m WHERE m.mobNo= :mobileNumber")
    Merchant getMerchantByMobNum(@Param("mobileNumber") String mobileNumber);

    @Query("SELECT m.merchantUsername, m.state FROM Merchant m WHERE m.mobNo = :mobNo")
    List<Object[]> getNameAndStateByMobNo(@Param("mobNo") String mobNo);

    @Query("SELECT new Merchant(m.merchantUsername, m.email) FROM Merchant m WHERE m.mobNo = :mobNo")
    Merchant getNameAndEmailByMobNo(@Param("mobNo") String mobNo);


}
