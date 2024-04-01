package com.app.crud.dto;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.model.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookMapperTest {
    private BookDTOMapper bookDTOMapper;

    @BeforeEach
    public void setup() {
        bookDTOMapper = new BookDTOMapper();
    }

    @Test
    @DisplayName("Map bookDTO object to book object")
    public void shouldMapBookDTOtoBook() {
        BookDTO expected = new BookDTO("ISBN", "title", "author", "genre", 1);
        Book actual = bookDTOMapper.mapToBook(expected);
        Assertions.assertNotNull(actual, "Book object is null");
        Assertions.assertNotNull(actual.getISBN(), "ISBN is null");
        Assertions.assertNotNull(actual.getTitle(), "Title is null");
        Assertions.assertNotNull(actual.getAuthor(), "Author is null");
        Assertions.assertNotNull(actual.getGenre(), "Genre is null");
        Assertions.assertEquals(expected.getISBN(), actual.getISBN(), "ISBN do not match");
        Assertions.assertEquals(expected.getTitle(), actual.getTitle(), "Title do not match");
        Assertions.assertEquals(expected.getAuthor(), actual.getAuthor(), "Author do not match");
        Assertions.assertEquals(expected.getGenre(), actual.getGenre(), "Genre do not match");
        Assertions.assertEquals(expected.getAmount(), actual.getAmount(), "Amount do not match");
    }

    @Test
    @DisplayName("Map book object to bookDTO object when Book is null")
    public void shouldMapBookToBookDTOWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> bookDTOMapper.mapToBookDTO(null));
    }

    @Test
    @DisplayName("Map bookDTO object to book object when BookDTO is null")
    public void shouldMapBookDTOToBookWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> bookDTOMapper.mapToBook(null));
    }

    @Test
    @DisplayName("Map book object to bookDTO object")
    public void shouldMapBookToBookDTO() {
        Book expected = new Book("ISBN", "title", "author", "genre", 1);
        BookDTO actual = bookDTOMapper.mapToBookDTO(expected);
        Assertions.assertNotNull(actual, "Book object is null");
        Assertions.assertNotNull(actual.getISBN(), "ISBN is null");
        Assertions.assertNotNull(actual.getTitle(), "Title is null");
        Assertions.assertNotNull(actual.getAuthor(), "Author is null");
        Assertions.assertNotNull(actual.getGenre(), "Genre is null");
        Assertions.assertEquals(expected.getISBN(), actual.getISBN(), "ISBN do not match");
        Assertions.assertEquals(expected.getTitle(), actual.getTitle(), "Title do not match");
        Assertions.assertEquals(expected.getAuthor(), actual.getAuthor(), "Author do not match");
        Assertions.assertEquals(expected.getGenre(), actual.getGenre(), "Genre do not match");
        Assertions.assertEquals(expected.getAmount(), actual.getAmount(), "Amount do not match");
    }
}
