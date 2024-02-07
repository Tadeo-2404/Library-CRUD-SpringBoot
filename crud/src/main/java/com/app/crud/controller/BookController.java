package com.app.crud.controller;

import com.app.crud.model.book.Book;
import com.app.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author,
                               @RequestParam(required = false) String genre,
                               @RequestParam(required = false) String ISBN,
                               @RequestParam(required = false) Integer amount) {
        if (title != null) {
            return bookService.getBooksByTitle(title);
        } else if (author != null) {
            return bookService.getBooksByAuthor(author);
        } else if (genre != null) {
            return bookService.getBooksByGenre(genre);
        } else if (amount != null) {
            return bookService.getBooksByAmount(amount);
        } else if (ISBN != null) {
            return bookService.getBooksByISBN(ISBN);
        }else {
            return bookService.getBooks();
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerBook(@RequestBody Book book) {
        return this.bookService.newProduct(book);
    }

    @PutMapping
    public ResponseEntity<Object> editBook(@RequestBody Book book) {
        return this.bookService.newProduct(book);
    }

    @DeleteMapping(path = "{ISBN}")
    public ResponseEntity<Object> deleteBook(@PathVariable("ISBN") String ISBN) {
        return this.bookService.removeBook(ISBN);
    }
}
