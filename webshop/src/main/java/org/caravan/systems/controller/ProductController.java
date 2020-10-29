package org.caravan.systems.controller;

import org.caravan.systems.model.Product;
import org.caravan.systems.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/productNumber/{productNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable String productNumber) {
        return new ResponseEntity<>(productService.getProduct(productNumber), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addProduct(@RequestBody Product Product) {
        return new ResponseEntity<>(productService.addProduct(Product), HttpStatus.OK);
    }

    @DeleteMapping("/productNumber/{productNumber}")
    public ResponseEntity deleteProduct(@PathVariable String productNumber) {
        productService.deleteProduct(productNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/productNumber/{productNumber}/quantity/{quantity}/locationCode/{locationCode}")
    public ResponseEntity setStock(@PathVariable String productNumber,
                         @PathVariable Integer quantity,
                         @PathVariable String locationCode) {
        productService.setStock(productNumber, quantity, locationCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
