package org.caravan.systems.service;

import org.caravan.systems.model.Product;
import org.caravan.systems.model.Stock;
import org.caravan.systems.repository.ProductRepository;
import org.caravan.systems.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String productNumber) {
        return productRepository.findByProductNumber(productNumber);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String isbn) {
        productRepository.deleteById(isbn);
    }

    public void setStock(String productNumber, int quantity, String locationCode) {
        Product product = productRepository.findById(productNumber).orElseThrow();
        product.setStock(new Stock(product.getStock().getNumberInStock() + quantity, locationCode));
        productRepository.save(product);
    }
}
