package com.app.crud.repository;

import com.app.crud.model.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    Book book;

    @BeforeEach
    public void setup() {
        book = new Book("ISBN", "title", "author", "genre", 10);
        this.bookRepository.save(book);
    }

    @Test
    public void findByTitleFound() {
        List<Book> bookList = this.bookRepository.findByTitle("title");
        Assertions.assertEquals(bookList.get(0).getTitle(), this.book.getTitle(), "Title not found");
    }

    @Test
    public void findByTitleNotFound() {
        List<Book> bookList = this.bookRepository.findByTitle("Unknown");
        Assertions.assertTrue(bookList.isEmpty(), "Title found");
    }

    @AfterEach
    public void teardown() {
        this.book = null;
        this.bookRepository.deleteAll();;
    }
}
