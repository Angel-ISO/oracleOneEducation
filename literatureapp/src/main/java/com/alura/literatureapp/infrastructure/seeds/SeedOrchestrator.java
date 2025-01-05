package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedOrchestrator implements CommandLineRunner {

    private final AuthorSeed authorSeed;
    private final EditorialSeed editorialSeed;
    private final GenreSeed genreSeed;
    private final LanguajeSeed languajeSeed;
    private final CountrySeed countrySeed;
    private final BooksSeed booksSeed;

    private final AuthorRepository autorRepository;
    private final EditorialRepository editorialRepository;
    private final GenreRepository genreRepository;
    private final LanguajeRepository languajeRepository;
    private final CountryRepository countryRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public SeedOrchestrator(AuthorSeed authorSeed, EditorialSeed editorialSeed, GenreSeed genreSeed,
                            LanguajeSeed languajeSeed, CountrySeed countrySeed, BooksSeed booksSeed,
                            AuthorRepository autorRepository, EditorialRepository editorialRepository,
                            GenreRepository genreRepository, LanguajeRepository languajeRepository,
                            CountryRepository countryRepository, BooksRepository booksRepository) {
        this.authorSeed = authorSeed;
        this.editorialSeed = editorialSeed;
        this.genreSeed = genreSeed;
        this.languajeSeed = languajeSeed;
        this.countrySeed = countrySeed;
        this.booksSeed = booksSeed;
        this.autorRepository = autorRepository;
        this.editorialRepository = editorialRepository;
        this.genreRepository = genreRepository;
        this.languajeRepository = languajeRepository;
        this.countryRepository = countryRepository;
        this.booksRepository = booksRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        countrySeed.initCountries(countryRepository).run(args);
        genreSeed.initGenres(genreRepository).run(args);
        authorSeed.initAuthors(autorRepository).run(args);
        languajeSeed.initLanguajes(languajeRepository, countryRepository).run(args);
        editorialSeed.initEditorials(editorialRepository, countryRepository).run(args);
        booksSeed.initBooks(booksRepository, autorRepository, languajeRepository, editorialRepository, genreRepository).run(args);

        System.out.println("all seeds initialized successfully");
    }

}
