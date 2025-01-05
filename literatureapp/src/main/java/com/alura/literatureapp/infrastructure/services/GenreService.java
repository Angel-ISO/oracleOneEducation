package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.core.entity.Genre;
import com.alura.literatureapp.core.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends GenericService<Genre, Long> {

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
    }
}
