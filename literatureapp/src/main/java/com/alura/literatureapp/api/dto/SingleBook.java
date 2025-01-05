package com.alura.literatureapp.api.dto;

public record SingleBook(
        String title,
        int publicationYear,
        String authorName,
        String languageName,
        String publisherName
) {
}
