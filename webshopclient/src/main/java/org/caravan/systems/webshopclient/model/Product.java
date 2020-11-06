package org.caravan.systems.webshopclient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    String productNumber;
    String description;
    Double price;
    Stock stock;

    public Product(String productNumber, String description, Double price, Stock stock) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(String productNumber, String description, Double price) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
