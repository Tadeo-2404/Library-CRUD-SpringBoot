package com.app.crud.controller;

import com.app.crud.dto.BookDTO;
import com.app.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getBooks(@RequestParam Map<String,String> allParams) {
        String ISBN = allParams.get("ISBN");
        String title = allParams.get("title");
        String author = allParams.get("author");
        String genre = allParams.get("genre");
        String amountStr = allParams.get("amount");
        Integer amount = null;
        if(amountStr != null) {
            amount = Integer.parseInt(amountStr);
        }

        if(allParams.size() > 1) {
            if(title != null && author != null) {
                return bookService.getBooksByTitleAndAuthor(title, author);
            } else if(title != null && genre != null) {
                return bookService.getBooksByTitleAndGenre(title, genre);
            } else if(title != null && amount != null) {
                return bookService.getBooksByTitleAndAmount(title, amount);
            } else if(title != null && author != null && genre != null) {
                return bookService.getBooksByTitleAndAuthorAndGenre(title, author, genre);
            } else if(author != null && genre != null) {
                return bookService.getBooksByAuthorAndGenre(author, genre);
            } else if(author != null && amount != null) {
                return bookService.getBooksByAuthorAndAmount(author, amount);
            } else if(genre != null && amount != null) {
                return bookService.getBooksByGenreAndAmount(genre, amount);
            } else if(title != null && author != null && amount != null) {
                return bookService.getBooksByTitleAndAuthorAndAmount(title, author, amount);
            } else if(title != null && genre != null && amount != null) {
                return bookService.getBooksByTitleAndGenreAndAmount(title, genre, amount);
            } else if(author != null && genre != null && amount != null) {
                return bookService.getBooksByAuthorAndGenreAndAmount(author, genre, amount);
            } else if(title != null && author != null && genre != null && amount != null) {
                return bookService.getBooksByTitleAndAuthorAndGenreAndAmount(title, author, genre, amount);
            }
        }

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
        } else {
            return bookService.getBooks();
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerBook(@RequestBody BookDTO book) {
        return this.bookService.newProduct(book);
    }

    @PutMapping
    public ResponseEntity<Object> editBook(@RequestBody BookDTO book) {
        return this.bookService.newProduct(book);
    }

    @DeleteMapping(path = "{ISBN}")
    public ResponseEntity<Object> deleteBook(@PathVariable("ISBN") String ISBN) {
        return this.bookService.removeBook(ISBN);
    }
}
