package com.microservices.admin_api_config.service;

import com.microservices.admin_api_config.model.Merchant;
import com.microservices.admin_api_config.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminPortalConsumerServiceImpl implements AdminPortalConsumerService {


    @Value("${merchant.service.merchant.url.findByMobNum}")
    private String findByNameUrl;
    /*External Configuration: It allows you to configure URLs (or any other values)
     externally without hardcoding them in your code. If the URL changes,
      you can update it in the application.properties file without modifying the code.

    Environment-Specific Configuration: You might have different URLs for different environments
    (development, testing, production). By using properties files,
     you can have separate files for each environment and inject the correct URL at runtime*/


    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Merchant getMerchantByMobNo(String mobNum) {
/*        String url = "http://localhost:8080/merchant/findByMobNum/{mobNum}";  // URL with path variable

        // Making the request using RestTemplate, with no request body (null) and empty headers (HttpEntity.EMPTY)
*//*        ResponseEntity<Merchant> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null, // No request body
                Merchant.class, // Response type
                mobNum // Passing mobNum as a path variable
        );*//*


*//*        ResponseEntity<Merchant> responseEntity = restTemplate.getForEntity(url,Merchant.class);

        return responseEntity.getBody();*//* // Returning the response body (Merchant object)


        return restTemplate.getForObject(url,Merchant.class,mobNum);*/


        return restTemplate.getForObject(findByNameUrl,Merchant.class,mobNum);
    }

    @Override
    public Product saveProduct(Product product) {

        String url = "http://DEMO/product/register";  // The URL to send the POST request

        // Create headers if needed
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // Assuming you're sending JSON data

        // Create the request entity (body + headers)
        HttpEntity<Product> requestEntity = new HttpEntity<>(product, headers);

        // Sending the POST request using exchange
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,  // The request entity with body and headers
                Product.class  // The response type
        );

        // Returning the response body (Product object)
        return responseEntity.getBody();
    }


/*    @Override
    public Product saveProduct(Product product) {
        String url = "http://localhost:8080/product/register";  // The URL to send the POST request

        // Sending the POST request with the 'product' object as the request body and expecting a 'Merchant' response
        return restTemplate.postForObject(url, product, Product.class);
    }*/



}
