package com.app.crud.service;

import com.app.crud.model.book.Book;
import com.app.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public List<Book> getBooksByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByAmount(int amount) {
        return bookRepository.findByAmount(amount);
    }

    public ResponseEntity<Object> newProduct(Book book) {
        HashMap<String, Object> message = new HashMap<>();
        try {
            if(book.getISBN() != null) {
                message.put("success", book);
                message.put("message", "Book edited successfully");
            } else {
                message.put("success", book);
                message.put("message", "Book created successfully");
            }

            this.bookRepository.save(book);
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            message.put("error", true);
            message.put("message", "Something went wrong");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }
    }

    public ResponseEntity<Object> removeBook(String isbn) {
        boolean exists = bookRepository.existsById(isbn);
        HashMap<String, Object> message = new HashMap<>();

        if(!exists) {
            message.put("error", true);
            message.put("message", "Book does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }

        try {
            message.put("message", "Book deleted successfully");
            this.bookRepository.deleteById(isbn);
            return new ResponseEntity<>(
                    message,
                    HttpStatus.ACCEPTED
            );
        } catch (Exception e) {
            message.put("error", true);
            message.put("message", "Something went wrong");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }
    }
}
