package com.springmvc.demo.controller;

import com.springmvc.demo.model.MerchantProductReq;
import com.springmvc.demo.model.Merchant;
import com.springmvc.demo.model.MerchantProductRes;
import com.springmvc.demo.model.Product;
import com.springmvc.demo.service.MerchantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;


    @Value("${pwd}")
    private String password;


    @PostMapping("register")
    public ResponseEntity<Merchant> register(@Valid @RequestBody Merchant merchant) {
        /*        System.out.println("Password configured in . properties file = " + password);*/
        Merchant registeredMerchant = merchantService.register(merchant);

        //Best Practise
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(registeredMerchant.getId())
                    .toUri();

            // Return a ResponseEntity with the location header
/*            return ResponseEntity.created(location).body(registeredMerchant);
        }*/

        return ResponseEntity.status(HttpStatus.CREATED).body(registeredMerchant);
    }

    @PostMapping("saveAllMerchants")
    public ResponseEntity<List<Merchant>> saveAllMerchants(@RequestBody List<Merchant> merchantList) {
        List<Merchant> merchantsList = merchantService.saveAllMerchants(merchantList);
        return ResponseEntity.status(HttpStatus.CREATED).body(merchantsList);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Merchant>> findAllMerchants(){
        List<Merchant> allMerchants = merchantService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allMerchants);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Merchant> findMerchantById(@PathVariable int id) {
        Merchant merchant = merchantService.findMerchantById(id);
        return ResponseEntity.ok(merchant);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteMerchantById(@PathVariable int id) {
        merchantService.deleteMerchantById(id);
    }

    @GetMapping("findByUsername/{username}")
    public ResponseEntity<Merchant> findByUsername(@PathVariable String username) {
        Merchant merchant = merchantService.findMerchantByUsername(username);
        return ResponseEntity.ok(merchant);

    }

    @GetMapping("findByMobNum/{mobNo}")
    public Merchant getMerchantByMobNo(@PathVariable String mobNo) {
        return merchantService.getMerchantsByMobNum(mobNo);
    }

    @GetMapping("getNameAndStateByMobNo/{mobNo}")
    public ResponseEntity<List<Object[]>> getNameAndStateByMobNo(@PathVariable String mobNo) {

        List<Object[]> list = merchantService.getNameAndStateByMobNo(mobNo);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("getNameAndEmailByMobNo/{mobNo}")
    public ResponseEntity<Merchant> getNameAndEmailByMobNo(@PathVariable String mobNo) {
        Merchant merchant = merchantService.getNameAndEmailByMobNo(mobNo);
        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }

    @GetMapping("saveMerchantAndProduct")
    public ResponseEntity<MerchantProductRes> saveMerchantAndProduct(@RequestBody MerchantProductReq merchantProductReq) {
        MerchantProductRes merchantProductRes = merchantService.saveMerchantAndProduct(merchantProductReq);
        return new ResponseEntity<>(merchantProductRes, HttpStatus.OK);
    }


}
