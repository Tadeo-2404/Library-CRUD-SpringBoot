package com.app.crud.service;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.model.book.Book;
import com.app.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public interface BookService {
    public ResponseEntity<Object> getBooks();

    public ResponseEntity<Object> getBooksByISBN(String ISBN);

    public ResponseEntity<Object> getBooksByTitle(String title);

    public ResponseEntity<Object> getBooksByAuthor(String author);

    public ResponseEntity<Object> getBooksByGenre(String genre);

    public ResponseEntity<Object> getBooksByAmount(int amount);

    public ResponseEntity<Object> getBooksByTitleAndAuthor(String title, String author);

    public ResponseEntity<Object> getBooksByTitleAndGenre(String title, String genre);

    public ResponseEntity<Object> getBooksByTitleAndAmount(String title, int amount);

    public ResponseEntity<Object> getBooksByAuthorAndGenre(String author, String genre);

    public ResponseEntity<Object> getBooksByAuthorAndAmount(String author, int amount);

    public ResponseEntity<Object> getBooksByGenreAndAmount(String genre, int amount);

    // Three Parameters
    public ResponseEntity<Object> getBooksByTitleAndAuthorAndGenre(String title, String author, String genre);

    public ResponseEntity<Object> getBooksByTitleAndAuthorAndAmount(String title, String author, int amount);

    public ResponseEntity<Object> getBooksByTitleAndGenreAndAmount(String title, String genre, int amount);

    public ResponseEntity<Object> getBooksByAuthorAndGenreAndAmount(String author, String genre, int amount);

    // Four Parameters
    public ResponseEntity<Object> getBooksByTitleAndAuthorAndGenreAndAmount(String title, String author, String genre, int amount);

    public ResponseEntity<Object> newProduct(BookDTO book);

    public ResponseEntity<Object> removeBook(String isbn);
}
