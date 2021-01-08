package com.example.stocks;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StockService {

    public Flux<StockPrice> generateStocks(String symbol) {
        Flux<StockPrice> stockFlux = Flux.interval(Duration.ofSeconds(5))
                .map(x -> new StockPrice(symbol, getPrice(), LocalDateTime.now()))
                .share();
        return stockFlux;
    }

    private Double getPrice() {
        return Math.ceil(ThreadLocalRandom.current().nextDouble(100.0));
    }
}
