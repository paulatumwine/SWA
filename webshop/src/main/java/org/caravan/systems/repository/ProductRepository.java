package org.caravan.systems.repository;

import org.caravan.systems.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findByProductNumber(String productNumber);
}
