package edu.miu.cs.cs590.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AccountController {

    @Autowired
    private Environment environment;

    @RequestMapping("/account/{customerid}")
    public Account getName(@PathVariable("customerid") String customerId) {
        System.out.println("Current Profile(s):");
        Arrays.stream(environment.getActiveProfiles()).forEach(System.out::println);
        return new Account("1234", "1000.00");
    }
}
