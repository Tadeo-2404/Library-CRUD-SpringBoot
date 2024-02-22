package com.app.crud.dto.mapper;

import com.app.crud.dto.BookDTO;
import com.app.crud.model.book.Book;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book book) {
        return new BookDTO(
                book.getISBN(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getAmount()
        );
    }
}
