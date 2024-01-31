package com.app.crud.service;

import com.app.crud.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public List<Book> getBooks() {
        return List.of(
                new Book("123", "libro", "juan", "fiction", 100)
        );
    }
}
