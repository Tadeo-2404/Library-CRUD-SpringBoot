package com.app.crud.repository;

import com.app.crud.model.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.Allure.suite;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    Book book;

    @BeforeEach
    public void setup() {
        step("initializes book object");
        book = new Book("title", "author", "genre", 10);
        step("saves book object");
        this.bookRepository.save(book);
    }

    @Test
    public void findByISBNFoundTest() {
        suite("findByISBN");
        step("Query findByISBN method");
        Book book = this.bookRepository.findByISBN(this.book.getISBN());
        step("Check if book is not null");
        Assertions.assertNotNull(book, "Book is null");
        step("Check if ISBN is equal");
        Assertions.assertEquals(book.getISBN(), this.book.getISBN(), "ISBN does not match");
    }

    @Test
    public void findByISBNNotFoundTest() {
        suite("findByISBN");
        step("Query findByISBN method");
        Book book = this.bookRepository.findByISBN("Unknown");
        step("Check if book is not null");
        Assertions.assertNull(book, "Book is not null");
    }

    @Test
    public void findByTitleFoundTest() {
        suite("findByTitle");
        step("Query findByTitle method");
        List<Book> bookList = this.bookRepository.findByTitle("title");
        step("Compares if book list if equal to book");
        Assertions.assertEquals(bookList.get(0).getTitle(), this.book.getTitle(), "Title not found");
    }

    @Test
    public void findByTitleNotFoundTest() {
        suite("findByTitle");
        step("Query findByTitle method passing argument with no results");
        List<Book> bookList = this.bookRepository.findByTitle("Unknown");
        step("Check if list is empty");
        Assertions.assertTrue(bookList.isEmpty(), "Title found");
    }

    @Test
    public void findByAuthorFoundTest() {
        suite("findByAuthor");
        step("Query findByAuthor method");
        List<Book> bookList = this.bookRepository.findByAuthor(this.book.getAuthor());
        step("Compares if book list if equal to book");
        Assertions.assertEquals(bookList.get(0).getAuthor(), this.book.getAuthor(), "Author not found");
    }

    @Test
    public void findByAuthorNotFoundTest() {
        suite("findByAuthor");
        step("Query findByAuthor method passing argument with no results");
        List<Book> bookList = this.bookRepository.findByAuthor("Unknown");
        step("Check if list is empty");
        Assertions.assertTrue(bookList.isEmpty(), "Author found");
    }

    @AfterEach
    public void teardown() {
        this.book = null;
        this.bookRepository.deleteAll();;
    }
}
