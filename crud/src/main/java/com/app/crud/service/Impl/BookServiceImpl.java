package com.app.crud.service.Impl;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.model.book.Book;
import com.app.crud.repository.BookRepository;
import com.app.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDTOMapper bookDTOMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookDTOMapper bookDTOMapper) {
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }

    public List<BookDTO> getBooks() {
        return this.bookRepository.findAll()
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByAmount(int amount) {
        return bookRepository.findByAmount(amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitleAndGenre(String title, String genre) {
        return bookRepository.findByTitleAndGenre(title, genre)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitleAndAmount(String title, int amount) {
        return bookRepository.findByTitleAndAmount(title, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByAuthorAndGenre(String author, String genre) {
        return bookRepository.findByAuthorAndGenre(author, genre)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByAuthorAndAmount(String author, int amount) {
        return bookRepository.findByAuthorAndAmount(author, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByGenreAndAmount(String genre, int amount) {
        return bookRepository.findByGenreAndAmount(genre, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    // Three Parameters
    public List<BookDTO> getBooksByTitleAndAuthorAndGenre(String title, String author, String genre) {
        return bookRepository.findByTitleAndAuthorAndGenre(title, author, genre)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitleAndAuthorAndAmount(String title, String author, int amount) {
        return bookRepository.findByTitleAndAuthorAndAmount(title, author, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByTitleAndGenreAndAmount(String title, String genre, int amount) {
        return bookRepository.findByTitleAndGenreAndAmount(title, genre, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByAuthorAndGenreAndAmount(String author, String genre, int amount) {
        return bookRepository.findByAuthorAndGenreAndAmount(author, genre, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    // Four Parameters
    public List<BookDTO> getBooksByTitleAndAuthorAndGenreAndAmount(String title, String author, String genre, int amount) {
        return bookRepository.findByTitleAndAuthorAndGenreAndAmount(title, author, genre, amount)
                .stream()
                .map(bookDTOMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> newProduct(BookDTO book) {
        HashMap<String, Object> message = new HashMap<>();
        try {
            if(book.getISBN() != null) {
                message.put("success", book);
                message.put("message", "Book edited successfully");
            } else {
                message.put("success", book);
                message.put("message", "Book created successfully");
            }

            Book bookToSave = new Book(
                    book.getISBN(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getAmount()
            );

            this.bookRepository.save(bookToSave);
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
