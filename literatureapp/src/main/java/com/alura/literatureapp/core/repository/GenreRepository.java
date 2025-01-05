package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Genre;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends BaseRepository<Genre, Long> {

    Optional<Genre> findByName(String name);
}
