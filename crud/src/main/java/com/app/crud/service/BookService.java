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
    public List<BookDTO> getBooks();

    public List<BookDTO> getBooksByISBN(String ISBN);

    public List<BookDTO> getBooksByTitle(String title);

    public List<BookDTO> getBooksByAuthor(String author);

    public List<BookDTO> getBooksByGenre(String genre);

    public List<BookDTO> getBooksByAmount(int amount);

    public List<BookDTO> getBooksByTitleAndAuthor(String title, String author);

    public List<BookDTO> getBooksByTitleAndGenre(String title, String genre);

    public List<BookDTO> getBooksByTitleAndAmount(String title, int amount);

    public List<BookDTO> getBooksByAuthorAndGenre(String author, String genre);

    public List<BookDTO> getBooksByAuthorAndAmount(String author, int amount);

    public List<BookDTO> getBooksByGenreAndAmount(String genre, int amount);

    // Three Parameters
    public List<BookDTO> getBooksByTitleAndAuthorAndGenre(String title, String author, String genre);

    public List<BookDTO> getBooksByTitleAndAuthorAndAmount(String title, String author, int amount);

    public List<BookDTO> getBooksByTitleAndGenreAndAmount(String title, String genre, int amount);

    public List<BookDTO> getBooksByAuthorAndGenreAndAmount(String author, String genre, int amount);

    // Four Parameters
    public List<BookDTO> getBooksByTitleAndAuthorAndGenreAndAmount(String title, String author, String genre, int amount);

    public ResponseEntity<Object> newProduct(BookDTO book);

    public ResponseEntity<Object> removeBook(String isbn);
}
