package com.app.crud.model;

import com.app.crud.model.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookModelTest {
    Book book;

    @BeforeEach
    public void setup() {
        book = new Book("ISBN", "title", "author", "genre", 1);
    }

    @Test
    public void constructorTest() {
        String ISBN = "ISBN";
        String title = "title";
        String author = "author";
        String genre = "genre";
        int amount = 1;
        Book expected = new Book(ISBN, title, author, genre, amount);

        Assertions.assertEquals(ISBN, expected.getISBN(), "Constructor did not initialize ISBN correctly");
        Assertions.assertEquals(title, expected.getTitle(), "Constructor did not initialize title correctly");
        Assertions.assertEquals(author, expected.getAuthor(), "Constructor did not initialize author correctly");
        Assertions.assertEquals(genre, expected.getGenre(), "Constructor did not initialize genre correctly");
        Assertions.assertEquals(amount, expected.getAmount(), "Constructor did not initialize amount correctly");
    }

    @Test
    public void getISBNTest() {
        String expectedISBN = "ISBN";
        String actualISBN = this.book.getISBN();
        Assertions.assertEquals(expectedISBN, actualISBN, "ISBN does not match");
    }

    @Test
    public void getTitleTest() {
        String expectedTitle = "title";
        String actualTitle = this.book.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "title does not match");
    }

    @Test
    public void getAuthorTest() {
        String expectedAuthor = "author";
        String actualAuthor = this.book.getAuthor();
        Assertions.assertEquals(expectedAuthor, actualAuthor, "author does not match");
    }

    @Test
    public void getGenreTest() {
        String expectedGenre = "genre";
        String actualGenre = this.book.getGenre();
        Assertions.assertEquals(expectedGenre, actualGenre, "genre does not match");
    }

    @Test
    public void getAmountTest() {
        int expectedAmount = 1;
        int actualAmount = this.book.getAmount();
        Assertions.assertEquals(expectedAmount, actualAmount, "amount does not match after getting");
    }

    @Test
    public void setISBNTest() {
        String expectedISBN = "NewISBN";
        this.book.setISBN(expectedISBN);
        String actualISBN = this.book.getISBN();
        Assertions.assertEquals(expectedISBN, actualISBN, "ISBN does not match after setting");
    }

    @Test
    public void setTitleTest() {
        String expectedTitle = "NewTitle";
        this.book.setTitle(expectedTitle);
        String actualTitle = this.book.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "Title does not match after setting");
    }

    @Test
    public void setAuthorTest() {
        String expectedAuthor = "NewAuthor";
        this.book.setAuthor(expectedAuthor);
        String actualAuthor = this.book.getAuthor();
        Assertions.assertEquals(expectedAuthor, actualAuthor, "Author does not match after setting");
    }

    @Test
    public void setGenreTest() {
        String expectedGenre = "NewGenre";
        this.book.setGenre(expectedGenre);
        String actualGenre = this.book.getGenre();
        Assertions.assertEquals(expectedGenre, actualGenre, "Genre does not match after setting");
    }

    @Test
    public void setAmountTest() {
        int expectedAmount = 5;
        this.book.setAmount(expectedAmount);
        int actualAmount = this.book.getAmount();
        Assertions.assertEquals(expectedAmount, actualAmount, "Amount does not match after setting");
    }

    @AfterEach
    public void teardown() {
        this.book = null;
    }
}
