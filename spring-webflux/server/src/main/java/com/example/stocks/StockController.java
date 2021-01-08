package com.example.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping(value="/stocks/{symbol}", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StockPrice> getAllStockPrices(@PathVariable String symbol) {
        return stockService.generateStocks(symbol);
    }
}
