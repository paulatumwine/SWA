package org.caravan.systems.service;

import org.caravan.systems.model.Cart;
import org.caravan.systems.model.Order;
import org.caravan.systems.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void createOrder(Cart cart) {
        Order order = new Order();
        order.setOrderNumber(cart.getCartId());
        order.setDate(LocalDate.now());
        order.setStatus(Order.OrderStatus.PENDING);
        orderRepository.save(order);
    }

    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }
}
