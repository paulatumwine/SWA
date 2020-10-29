package org.caravan.systems.repository;

import org.caravan.systems.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByIsbn(String isbn);
}
