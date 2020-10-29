package org.caravan.systems.service;

import org.caravan.systems.model.Book;
import org.caravan.systems.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
