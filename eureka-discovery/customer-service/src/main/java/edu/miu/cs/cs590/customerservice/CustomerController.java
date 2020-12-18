package edu.miu.cs.cs590.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    AccountFeignClient accountClient;

    @RequestMapping("/customer/{customerid}")
    public Account getName(@PathVariable("customerid") String customerId) {
        Account account = accountClient.getName(customerId);
        return account;
    }

    @FeignClient("AccountService")
    interface AccountFeignClient {
        @RequestMapping("/account/{customerid}")
        Account getName(@PathVariable("customerid") String customerId);
    }
}
