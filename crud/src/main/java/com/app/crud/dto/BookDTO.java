package com.app.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class BookDTO implements Serializable {
    final private String ISBN;
    final private String title;
    final private String author;
    final private String genre;
    final private int amount;
}
