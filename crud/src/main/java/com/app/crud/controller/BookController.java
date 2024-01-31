package com.app.crud.controller;

import com.app.crud.book.Book;
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
    public List<Book> getBooks() {
        return bookService.getBooks();
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
