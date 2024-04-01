package com.app.crud.dto.mapper;

import com.app.crud.dto.BookDTO;
import com.app.crud.model.book.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDTOMapper {
    public BookDTO mapToBookDTO(Book book) {
        if (book == null) {
            throw new NullPointerException("The book is null");
        }
        return new BookDTO(
                book.getISBN(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getAmount()
        );
    }

    public Book mapToBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new NullPointerException("The bookDTO is null");
        }
        return new Book(
                bookDTO.getISBN(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getGenre(),
                bookDTO.getAmount()
        );
    }
}
