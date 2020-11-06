package org.caravan.systems.controller;

import org.caravan.systems.model.Cart;
import org.caravan.systems.model.Order;
import org.caravan.systems.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId) {
        Order order = orderService.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(Cart cart) {
        orderService.createOrder(cart);
        return new ResponseEntity(HttpStatus.OK);
    }
}
