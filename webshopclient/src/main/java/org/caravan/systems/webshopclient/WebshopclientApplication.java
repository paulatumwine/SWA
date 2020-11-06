package org.caravan.systems.webshopclient;

import org.caravan.systems.webshopclient.model.Order;
import org.caravan.systems.webshopclient.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebshopclientApplication implements CommandLineRunner {

    public static final String BASE_URL = "http://localhost:8090";
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(WebshopclientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Product p1 = new Product(), p2 = new Product();
        p1.setProductNumber("12345");
        p1.setDescription("A product of some sort");
        p1.setPrice(9.99);
        restTemplate.postForLocation(BASE_URL + "/product", p1);

        p2.setProductNumber("65432");
        p2.setDescription("A product of more sorts");
        p2.setPrice(4.49);
        restTemplate.postForLocation(BASE_URL + "/product", p2);

        String cartId = "1";
//        Map<String, Object> params = new HashMap<>();
//        params.put("cartId", cartId);
//        params.put("productNumber", p1.getProductNumber());
//        params.put("quantity", 3);
//        restTemplate.patchForObject(BASE_URL + "/cart", null, ResponseEntity.class, params);

        restTemplate.postForLocation(
                String.format("%s/cart/%s/%s/%d", BASE_URL, cartId, p1.getProductNumber(), 3), null);

        restTemplate.postForLocation(
                String.format("%s/cart/%s/%s/%d", BASE_URL, cartId, p2.getProductNumber(), 2), null);

        ResponseEntity<Order> response = restTemplate.getForEntity(BASE_URL + "/order/" + cartId, Order.class);
        System.out.println(response.getBody());
    }
}
