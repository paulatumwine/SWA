package org.caravan.systems.repository;

import org.caravan.systems.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    public Cart findByCartId(String cartId);
}
