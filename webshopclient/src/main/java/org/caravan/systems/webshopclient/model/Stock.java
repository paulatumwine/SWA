package org.caravan.systems.webshopclient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
    @Id
    String locationCode;
    Integer numberInStock;

    public Stock() {
    }

    public Stock(Integer numberInStock, String locationCode) {
        this.numberInStock = numberInStock;
        this.locationCode = locationCode;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
