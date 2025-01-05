package com.alura.literatureapp.api.dto;

import java.util.Set;

public record BookDto(
        String title,
        int publicationYear,
        String authorName,
        String languageName,
        String publisherName,
        Set<String> genres
){
}
