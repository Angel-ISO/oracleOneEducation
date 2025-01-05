package com.alura.literatureapp.api.controller;

import com.alura.literatureapp.api.dto.BookDto;
import com.alura.literatureapp.api.dto.SingleBook;
import com.alura.literatureapp.core.entity.Books;
import com.alura.literatureapp.infrastructure.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/books")
@RestController
public class BooksController implements BaseApiController<Books, Long> {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public ResponseEntity<List<SingleBook>> getAll() {
        List<Books> books = booksService.getAll();
        List<SingleBook> dtos = books.stream()
                .map(book-> new SingleBook(
                        book.getTitle(),
                        book.getPublicationYear(),
                        book.getAuthor().getFullName(),
                        book.getLanguage().getName(),
                        book.getPublisher().getName()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/search")
    public List<BookDto> getBooksByTitle(@RequestParam String title) {
        return booksService.getBooksByTitle(title);
    }


    @Override
    public ResponseEntity<?> getOne(Long aLong) {
        return ResponseEntity.status(405).body("This method not be created yet");
    }

    @Override
    public ResponseEntity<?> save(Books entity) {
        return ResponseEntity.status(405).body("This method not be created yet.");
    }

    @Override
    public ResponseEntity<?> update(Long aLong, Books entity) {
        return ResponseEntity.status(405).body("This method not be created yet");
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return ResponseEntity.status(405).body("This method not be created yet.");

    }
}
