package org.caravan.systems.controller;

import org.caravan.systems.model.Book;
import org.caravan.systems.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        return new ResponseEntity<>(bookService.getBook(isbn), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/isbn/{isbn}")
    public ResponseEntity deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
