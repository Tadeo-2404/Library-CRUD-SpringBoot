package com.app.crud.model.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ISBN", nullable = false, unique = true) // Keep unique constraint
    private String ISBN;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "author", nullable = false, length = 50)
    private String author;
    @Column(name = "genre", nullable = false, length = 50)
    private String genre;
    @Column(name = "amount", nullable = false)
    private int amount;

    public Book(String title, String author, String genre, int amount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.amount = amount;
    }
}