package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.entity.Genre;
import com.alura.literatureapp.core.repository.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreSeed {


     CommandLineRunner initGenres(GenreRepository genreRepository) {
        return args -> {
            if (genreRepository.count() > 0) {
                System.out.println("Genres already initialized. Skipping seed.");
                return;
            }

            Genre fiction = Genre.builder()
                    .name("Fiction")
                    .build();

            Genre nonFiction = Genre.builder()
                    .name("Non-fiction")
                    .build();

            Genre mystery = Genre.builder()
                    .name("Mystery")
                    .build();

            Genre fantasy = Genre.builder()
                    .name("Fantasy")
                    .build();

            Genre scienceFiction = Genre.builder()
                    .name("Dystopian")
                    .build();

            genreRepository.saveAll(List.of(fiction, nonFiction, mystery, fantasy, scienceFiction));

            System.out.println("Genres initialized successfully.");
        };
    }
}
