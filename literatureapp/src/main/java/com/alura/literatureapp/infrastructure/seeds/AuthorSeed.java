package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.entity.Author;
import com.alura.literatureapp.core.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class AuthorSeed {

     CommandLineRunner initAuthors(AuthorRepository authorRepository) {
        return args -> {
            if (authorRepository.count() > 0) {
                System.out.println("Authors already initialized. Skipping seed.");
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Author author1 = Author.builder()
                        .fullName("Gabriel García Márquez")
                        .bornDate(dateFormat.parse("1927-03-06"))
                        .diedDate(dateFormat.parse("2014-04-17"))
                        .nationality("Colombian")
                        .build();

                Author author2 = Author.builder()
                        .fullName("J.K. Rowling")
                        .bornDate(dateFormat.parse("1965-07-31"))
                        .nationality("British")
                        .build();

                Author author3 = Author.builder()
                        .fullName("Mario Vargas Llosa")
                        .bornDate(dateFormat.parse("1936-03-28"))
                        .nationality("Peruvian")
                        .build();

                Author author4 = Author.builder()
                        .fullName("George Orwell")
                        .bornDate(dateFormat.parse("1948-09-20"))
                        .nationality("American")
                        .build();

                authorRepository.saveAll(List.of(author1, author2, author3, author4));

                System.out.println("Authors initialized successfully.");
            } catch (Exception e) {
                System.out.println("Error initializing authors: " + e.getMessage());
            }
        };
    }

}
