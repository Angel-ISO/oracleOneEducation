package com.alura.literatureapp.infrastructure.seeds;


import com.alura.literatureapp.core.entity.*;
import com.alura.literatureapp.core.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BooksSeed {

     CommandLineRunner initBooks(BooksRepository booksRepository,
                                       AuthorRepository authorRepository,
                                       LanguajeRepository languajeRepository,
                                       EditorialRepository editorialRepository,
                                       GenreRepository genreRepository) {
        return args -> {
            if (booksRepository.count() > 0) {
                System.out.println("Books already initialized. Skipping seed.");
                return;
            }

            Author author1 = authorRepository.findByFullName("J.K. Rowling")
                    .orElseThrow(() -> new RuntimeException("Author with full name 'J.K. Rowling' not found"));
            Author author2 = authorRepository.findByFullName("George Orwell")
                    .orElseThrow(() -> new RuntimeException("Author with full name 'George Orwell' not found"));

            Languaje languaje1 = languajeRepository.findByName("EnglishUnitedStates")
                    .orElseThrow(() -> new RuntimeException("Language with name 'EnglishUnitedStates' not found"));
            Languaje languaje2 = languajeRepository.findByName("SpanishEspana")
                    .orElseThrow(() -> new RuntimeException("Language with name 'SpanishEspana' not found"));

            Editorial editorial1 = editorialRepository.findByName("Bloomsbury")
                    .orElseThrow(() -> new RuntimeException("Editorial with name 'Bloomsbury' not found"));
            Editorial editorial2 = editorialRepository.findByName("Penguin")
                    .orElseThrow(() -> new RuntimeException("Editorial with name 'Penguin' not found"));

            Genre genre1 = genreRepository.findByName("Fantasy")
                    .orElseThrow(() -> new RuntimeException("Genre with name 'Fantasy' not found"));
            Genre genre2 = genreRepository.findByName("Dystopian")
                    .orElseThrow(() -> new RuntimeException("Genre with name 'Dystopian' not found"));

            if (author1 == null || author2 == null || languaje1 == null || languaje2 == null ||
                    editorial1 == null || editorial2 == null || genre1 == null || genre2 == null) {
                System.out.println("One or more entities not found. Skipping book seeding.");
                return;
            }


            Books book1 = Books.builder()
                    .title("Harry Potter and the Philosopher's Stone")
                    .publicationYear(1997)
                    .author(author1)
                    .language(languaje1)
                    .publisher(editorial1)
                    .build();

            Books book2 = Books.builder()
                    .title("1984")
                    .publicationYear(1949)
                    .author(author2)
                    .language(languaje2)
                    .publisher(editorial2)
                    .build();

            booksRepository.saveAll(Set.of(book1, book2));
            System.out.println("Books createdsuccessfully.");



            book1.setGenres(new HashSet<>(Set.of(genre1, genre2)));
            book2.setGenres(new HashSet<>(Set.of(genre2)));

            System.out.println("Books relations createdsuccessfully.");


            booksRepository.saveAll(Set.of(book1, book2));
            System.out.println("Books initialized successfully.");
        };
    }
}
