package com.app.crud.repository;

import com.app.crud.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findByISBN(String ISBN);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    List<Book> findByAmount(int amount);
    //two params
    List<Book> findByTitleAndAuthor(String title, String author);
    List<Book> findByTitleAndGenre(String title, String genre);
    List<Book> findByTitleAndAmount(String title, int amount);
    List<Book> findByAuthorAndGenre(String author, String genre);
    List<Book> findByAuthorAndAmount(String author, int amount);
    List<Book> findByGenreAndAmount(String genre, int amount);
    //three params
    List<Book> findByTitleAndAuthorAndGenre(String title, String author, String genre);
    List<Book> findByTitleAndAuthorAndAmount(String title, String author, int amount);
    List<Book> findByTitleAndGenreAndAmount(String title, String genre, int amount);
    List<Book> findByAuthorAndGenreAndAmount(String author, String genre, int amount);
    //four params
    List<Book> findByTitleAndAuthorAndGenreAndAmount(String title, String author, String genre, int amount);
}
