package com.example.stocks;

import java.time.LocalDateTime;

public class StockPrice {
    String symbol;
    Double price;
    LocalDateTime time;

    public StockPrice() {
    }

    public StockPrice(String symbol, Double price, LocalDateTime time) {
        this.symbol = symbol;
        this.price = price;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
