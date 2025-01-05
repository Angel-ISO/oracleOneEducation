package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.core.entity.Author;
import com.alura.literatureapp.core.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends GenericService<Author, Long> {

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }
}
