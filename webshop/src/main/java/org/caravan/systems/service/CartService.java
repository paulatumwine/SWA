package org.caravan.systems.service;

import org.caravan.systems.model.Cart;
import org.caravan.systems.model.Product;
import org.caravan.systems.model.Stock;
import org.caravan.systems.repository.CartRepository;
import org.caravan.systems.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCart(String cartId) {
        return cartRepository.findByCartId(cartId);
    }

    public void addToCart(String cartId, String productNumber, Integer quantity) {
        Product product = productRepository.findById(productNumber).orElseThrow();
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.setQuantity(cart.getQuantity() == null ? quantity : cart.getQuantity() + quantity);
        if (cart.getProductList() == null) {
            List<Product> list = new ArrayList<>();
            list.add(product);
            cart.setProductList(list);
        }
        else cart.getProductList().add(product);
        cartRepository.save(cart);
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(String isbn) {
        cartRepository.deleteById(isbn);
    }

    public void checkout(String cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        orderService.createOrder(cart);
    }
}
