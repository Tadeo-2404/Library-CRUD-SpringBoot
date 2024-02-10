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
    @Column(name = "ISBN", unique = true, nullable = false)
    private String ISBN;
    @Column(name = "title", unique = false, nullable = false, length = 50)
    private String title;
    @Column(name = "author", unique = false, nullable = false, length = 50)
    private String author;
    @Column(name = "genre", unique = false, nullable = false, length = 50)
    private String genre;
    @Column(name = "amount", unique = false, nullable = false)
    private int amount;
}
