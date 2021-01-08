package com.example.stocks;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class StockService {

    public Flux<StockPrice> generateStocks(String symbol) {
        Flux<StockPrice> result = WebClient.create("http://localhost:8080/stocks/" + symbol)
                .get()
                .retrieve()
                .bodyToFlux(StockPrice.class);
        result.subscribe(s -> {
            System.out.print("DEBUG - Received stock : ");
            System.out.println(s);
        });
        return result;
    }

}
