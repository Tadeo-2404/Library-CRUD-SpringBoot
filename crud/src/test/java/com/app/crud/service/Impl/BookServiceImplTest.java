package com.app.crud.service.Impl;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.model.book.Book;
import com.app.crud.repository.BookRepository;
import com.app.crud.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static io.qameta.allure.Allure.step;

class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;
    private BookService bookService;
    @Mock
    private BookDTOMapper bookDTOMapper;
    AutoCloseable autoCloseable;
    Book book;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository, bookDTOMapper);
        book = new Book("title", "author", "genre", 1);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getBooks() {
        step("Mock behavior of BookRepository to return a list containing a single book");
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));

        step("Mock behavior of BookDTOMapper to return a non-null BookDTO object");
        BookDTO mockedBookDTO = new BookDTO("ISBN", "Title", "Author", "Genre", 1);
        when(bookDTOMapper.mapToBookDTO(any(Book.class))).thenReturn(mockedBookDTO);

        step("Invoke the method under test");
        ResponseEntity<Object> responseEntity = bookService.getBooks();

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify the status response");
        Map<String, Object> dataMap = (Map<String, Object>) responseEntity.getBody();
        assertEquals(1, dataMap.get("status"), "Status should be 1 (success)");

        List<BookDTO> data = (List<BookDTO>) dataMap.get("data");
        step("Verify data response not to be null");
        assertNotNull(data, "Data should not be null");
        step("Verify data response not to be empty");
        assertFalse(data.isEmpty(), "Data should not be empty");

        step("Verify that the title of the first book in the list matches the title of the mocked book");
        assertNotNull(data.get(0), "BookDTO should not be null");
        assertEquals(mockedBookDTO.getTitle(), data.get(0).getTitle(), "Title of first book should match");
    }


    @Test
    void getBooksByISBN() {
        step("Mock behavior of BookRepository");
        when(bookRepository.findByISBN(this.book.getISBN())).thenReturn(this.book);

        step("Mock behavior of BookDTOMapper to return a BookDTO object");
        BookDTO expectedBookDTO = new BookDTO(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAmount());
        when(bookDTOMapper.mapToBookDTO(eq(book))).thenReturn(expectedBookDTO);

        step("Invoke the method under test");
        ResponseEntity<Object> responseEntity = bookService.getBooksByISBN(this.book.getISBN());
        Map<String, Object> dataMap = (Map<String, Object>) responseEntity.getBody();

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify the status response");
        int status = (int) dataMap.get("status");
        assertEquals(1, status, "Status should be 1 (success)");

        step("Verify the data response");
        Object data = dataMap.get("data");
        assertNotNull(data, "Data should not be null");

        BookDTO actualBookDTO = (BookDTO) data;
        step("Check if ISBN is equal");
        assertEquals(expectedBookDTO.getISBN(), actualBookDTO.getISBN(), "ISBN does not match");
        step("Check if title is equal");
        assertEquals(expectedBookDTO.getTitle(), actualBookDTO.getTitle(), "Title does not match");
        step("Check if author is equal");
        assertEquals(expectedBookDTO.getAuthor(), actualBookDTO.getAuthor(), "Author does not match");
        step("Check if genre is equal");
        assertEquals(expectedBookDTO.getGenre(), actualBookDTO.getGenre(), "Genre does not match");
        step("Check if amount is equal");
        assertEquals(expectedBookDTO.getAmount(), actualBookDTO.getAmount(), "Amount does not match");
    }

    @Test
    void getBooksByTitle() {
    }

    @Test
    void getBooksByAuthor() {
    }

    @Test
    void getBooksByGenre() {
    }

    @Test
    void getBooksByAmount() {
    }

    @Test
    void getBooksByTitleAndAuthor() {
    }

    @Test
    void getBooksByTitleAndGenre() {
    }

    @Test
    void getBooksByTitleAndAmount() {
    }

    @Test
    void getBooksByAuthorAndGenre() {
    }

    @Test
    void getBooksByAuthorAndAmount() {
    }

    @Test
    void getBooksByGenreAndAmount() {
    }

    @Test
    void getBooksByTitleAndAuthorAndGenre() {
    }

    @Test
    void getBooksByTitleAndAuthorAndAmount() {
    }

    @Test
    void getBooksByTitleAndGenreAndAmount() {
    }

    @Test
    void getBooksByAuthorAndGenreAndAmount() {
    }

    @Test
    void getBooksByTitleAndAuthorAndGenreAndAmount() {
    }

    @Test
    void newProduct() {
        // Mock behavior of bookRepository.save() to return the saved book
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.newProduct(book);

        // Verify the HTTP response status
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        // Verify the response body
        Map<String, Object> dataMap = (Map<String, Object>) responseEntity.getBody();
        assertNotNull(dataMap, "Data map should not be null");

        // Verify the status
        assertEquals(1, dataMap.get("status"), "Status should be 1 (Success)");

        // Verify the message
        assertEquals("book created successfully", dataMap.get("message"), "Message should indicate successful book creation");

        // Verify the data
        Book responseData = (Book) dataMap.get("data");
        assertNotNull(responseData, "Response data should not be null");
        assertEquals(book.getISBN(), responseData.getISBN(), "ISBN in response data should match");
        assertEquals(book.getTitle(), responseData.getTitle(), "Title in response data should match");
    }


    @Test
    void removeBook() {
    }
}