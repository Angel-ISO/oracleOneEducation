package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends BaseRepository<Author, Long> {

    Optional<Author> findByFullName(String fullName);
}
