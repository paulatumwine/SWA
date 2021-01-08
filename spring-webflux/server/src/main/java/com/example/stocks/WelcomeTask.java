package com.example.stocks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WelcomeTask {

    @Scheduled(fixedRate = 5000)
    public void welcome() {
        System.out.println("This task runs at " + LocalDateTime.now());
    }
}
