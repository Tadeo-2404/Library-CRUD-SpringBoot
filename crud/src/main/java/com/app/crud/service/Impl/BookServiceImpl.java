package com.app.crud.service.Impl;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.model.book.Book;
import com.app.crud.repository.BookRepository;
import com.app.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDTOMapper bookDTOMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookDTOMapper bookDTOMapper) {
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }

    public ResponseEntity<Object> getBooks() {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
           List<BookDTO> list = this.bookRepository.findAll()
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByISBN(String ISBN) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            Book book = this.bookRepository.findByISBN(ISBN);
            BookDTO bookDTO = bookDTOMapper.mapToBookDTO(book);

            if(book != null) {
                dataMap.put("status", 1);
                dataMap.put("data", bookDTO);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "Not found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitle(String title) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitle(title)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAuthor(String author) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByAuthor(author)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByGenre(String genre) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByGenre(genre)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAmount(int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByAmount(amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitleAndAuthor(String title, String author) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndAuthor(title, author)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitleAndGenre(String title, String genre) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndGenre(title, genre)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitleAndAmount(String title, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndAmount(title, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAuthorAndGenre(String author, String genre) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByAuthorAndGenre(author, genre)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAuthorAndAmount(String author, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByAuthorAndAmount(author, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByGenreAndAmount(String genre, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByGenreAndAmount(genre, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Three Parameters
    public ResponseEntity<Object> getBooksByTitleAndAuthorAndGenre(String title, String author, String genre) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndAuthorAndGenre(title, author, genre)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitleAndAuthorAndAmount(String title, String author, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndAuthorAndAmount(title, author, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByTitleAndGenreAndAmount(String title, String genre, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndGenreAndAmount(title, genre, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAuthorAndGenreAndAmount(String author, String genre, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByAuthorAndGenreAndAmount(author, genre, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Four Parameters
    public ResponseEntity<Object> getBooksByTitleAndAuthorAndGenreAndAmount(String title, String author, String genre, int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<BookDTO> list = this.bookRepository.findByTitleAndAuthorAndGenreAndAmount(title, author, genre, amount)
                    .stream()
                    .map(bookDTOMapper::mapToBookDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> newProduct(BookDTO book) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
            if(book.getISBN() != null) {
                dataMap.put("status", 1);
                dataMap.put("data", book);
                dataMap.put("message", "book edited successfully");
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", book);
                dataMap.put("message", "book created successfully");
            }

            Book bookToSave = new Book(
                    book.getISBN(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getAmount()
            );

            this.bookRepository.save(bookToSave);
            return new ResponseEntity<>(dataMap, HttpStatus.OK);
        } catch (Exception e) {
            dataMap.put("status", 1);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> removeBook(String isbn) {
        boolean exists = bookRepository.existsById(isbn);
        Map<String, Object> dataMap = new HashMap<String, Object>();

        if(!exists) {
            dataMap.put("status", 1);
            dataMap.put("data", "Book not found");
            return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
        }

        try {
            dataMap.put("status", 1);
            dataMap.put("data", "Book deleted successfully");
            this.bookRepository.deleteById(isbn);
            return new ResponseEntity<>(dataMap, HttpStatus.OK);
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
