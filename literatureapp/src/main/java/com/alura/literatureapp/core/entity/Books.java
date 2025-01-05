package com.alura.literatureapp.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books extends BaseEntity {

    @Column(name = "title", unique = true)
    private String title;


    @Column(name = "publication_year", nullable = false)
    private int publicationYear;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Languaje language;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Editorial publisher;

    @ManyToMany
    @JoinTable(
            name = "libro_genero",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;








}
