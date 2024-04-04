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
        // Mock behavior of BookRepository
        when(bookRepository.findByTitle(this.book.getTitle())).thenReturn(
                Collections.singletonList(book)
        );

        // Mock behavior of BookDTOMapper to return a valid BookDTO object
        when(bookDTOMapper.mapToBookDTO(any(Book.class)))
                .thenReturn(new BookDTO(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAmount()));

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.getBooksByTitle(this.book.getTitle());
        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        List<BookDTO> books = (List<BookDTO>) responseBody.get("data");
        int status = (int) responseBody.get("status");

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify status 1");
        assertEquals(1, status, "Status should be 1 (success)");

        step("Verify data is not null");
        assertNotNull(books);

        step("check if data is equal");
        assertEquals(book.getISBN(), books.get(0).getISBN(), "Attributes does not match");
    }

    @Test
    void getBooksByAuthor() {
        // Mock behavior of BookRepository
        when(bookRepository.findByAuthor(this.book.getAuthor())).thenReturn(
                Collections.singletonList(book)
        );

        // Mock behavior of BookDTOMapper to return a valid BookDTO object
        when(bookDTOMapper.mapToBookDTO(any(Book.class)))
                .thenReturn(new BookDTO(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAmount()));

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.getBooksByAuthor(this.book.getAuthor());
        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        List<BookDTO> books = (List<BookDTO>) responseBody.get("data");
        int status = (int) responseBody.get("status");

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify status 1");
        assertEquals(1, status, "Status should be 1 (success)");

        step("Verify data is not null");
        assertNotNull(books);

        step("check if data is equal");
        assertEquals(book.getISBN(), books.get(0).getISBN(), "Attributes does not match");
    }

    @Test
    void getBooksByGenre() {
        // Mock behavior of BookRepository
        when(bookRepository.findByGenre(this.book.getGenre())).thenReturn(
                Collections.singletonList(book)
        );

        // Mock behavior of BookDTOMapper to return a valid BookDTO object
        when(bookDTOMapper.mapToBookDTO(any(Book.class)))
                .thenReturn(new BookDTO(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAmount()));

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.getBooksByGenre(this.book.getGenre());
        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        List<BookDTO> books = (List<BookDTO>) responseBody.get("data");
        int status = (int) responseBody.get("status");

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify status 1");
        assertEquals(1, status, "Status should be 1 (success)");

        step("Verify data is not null");
        assertNotNull(books);

        step("check if data is equal");
        assertEquals(book.getISBN(), books.get(0).getISBN(), "Attributes does not match");
    }

    @Test
    void getBooksByAmount() {
        // Mock behavior of BookRepository
        when(bookRepository.findByAmount(this.book.getAmount())).thenReturn(
                Collections.singletonList(book)
        );

        // Mock behavior of BookDTOMapper to return a valid BookDTO object
        when(bookDTOMapper.mapToBookDTO(any(Book.class)))
                .thenReturn(new BookDTO(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAmount()));

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.getBooksByAmount(this.book.getAmount());
        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        List<BookDTO> books = (List<BookDTO>) responseBody.get("data");
        int status = (int) responseBody.get("status");

        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        step("Verify status 1");
        assertEquals(1, status, "Status should be 1 (success)");

        step("Verify data is not null");
        assertNotNull(books);

        step("check if data is equal");
        assertEquals(book.getISBN(), books.get(0).getISBN(), "Attributes does not match");
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
        // Mock behavior of bookRepository.existsById() to return true
        when(bookRepository.existsById(this.book.getISBN())).thenReturn(true);

        // Invoke the method under test
        ResponseEntity<Object> responseEntity = bookService.removeBook(this.book.getISBN());
        Map<String, Object> dataMap = (Map<String, Object>) responseEntity.getBody();

        // Verify the HTTP response status
        step("Verify the HTTP response status");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");

        // Verify the status response
        step("Verify the status response");
        int status = (int) dataMap.get("status");
        assertEquals(1, status, "Status should be 1 (success)");

        // Verify the data response
        step("Verify the data response");
        Object data = dataMap.get("data");
        assertNotNull(data, "Data should not be null");
        assertEquals("Book deleted successfully", data, "Message should indicate successful deletion");
    }
}