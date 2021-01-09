package com.example.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    OAuth2RestTemplate restTemplate;

    @GetMapping("/productdata")
    public String getPublicInfo() {
        return "Product Info";
    }

    @GetMapping("/contactdata")
    public String getUserInfo() {
        return restTemplate.getForObject("http://localhost:8090/phone", String.class);
    }

    @GetMapping("/salarydata")
    public String getManagerInfo() {
        return restTemplate.getForObject("http://localhost:8091/salary", String.class);
    }

}
