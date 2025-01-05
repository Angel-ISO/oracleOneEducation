package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.api.dto.BookDto;
import com.alura.literatureapp.api.dto.SingleBook;
import com.alura.literatureapp.core.entity.Books;
import com.alura.literatureapp.core.entity.Genre;
import com.alura.literatureapp.core.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BooksService extends GenericService<Books, Long> {

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        super(booksRepository);
        this.booksRepository = booksRepository;
    }

    private final BooksRepository booksRepository;

    public List<BookDto> getBooksByTitle(String title) {
        List<Books> books = booksRepository.findBooksByTitle(title);

        return books.stream().map(book -> {
            Set<String> genres = book.getGenres().stream()
                    .map(Genre::getName)
                    .collect(Collectors.toSet());

            return new BookDto(
                    book.getTitle(),
                    book.getPublicationYear(),
                    book.getAuthor().getFullName(),
                    book.getLanguage().getName(),
                    book.getPublisher().getName(),
                    Collections.singleton(String.join(", ", genres))
            );
        }).collect(Collectors.toList());
    }

}
