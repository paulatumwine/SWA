package com.example.servicec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/salary")
    public String getGetSalary() {
        return "95.000";
    }

}
