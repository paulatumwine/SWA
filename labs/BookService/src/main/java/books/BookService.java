package books;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookService {
	@Autowired
	BookRepository bookRepository;	

    public Book getBook(String isbn) {
    	System.out.println(isbn);
		Optional<Book> bookOptional = bookRepository.findById(isbn);
		if (bookOptional.isPresent()) {
			System.out.println("yes");
			return bookOptional.get();
		}
		else
          return null;
    }


    public void deleteBook(String isbn) {
    	bookRepository.deleteById(isbn);
    }
	

    public Book addBook(Book book) {
    	bookRepository.save(book);
        return book;
    }

    public Book updateBook(Book book) {
		bookRepository.save(book);
		return book;
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }

	
}


