package org.caravan.systems.controller;

import org.caravan.systems.model.Cart;
import org.caravan.systems.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<>(cartService.getCarts(), HttpStatus.OK);
    }

    @GetMapping("/cartId/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {
        return new ResponseEntity<>(cartService.getCart(cartId), HttpStatus.OK);
    }

    @PatchMapping("cartId/{cartId}/productNumber/{productNumber}/quantity/{quantity}")
    public ResponseEntity addToCart(@PathVariable String cartId,
                                    @PathVariable String productNumber, @PathVariable Integer quantity) {
        cartService.addToCart(cartId, productNumber, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.OK);
    }

    @DeleteMapping("/cartId/{cartId}")
    public ResponseEntity deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("{cartId}")
    public ResponseEntity checkout(@PathVariable String cartId) {
        cartService.checkout(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
