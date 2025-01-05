package com.alura.literatureapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(name = "full_name", unique = true)
    private String fullName;

    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "died_date", nullable = true)
    private Date diedDate;

    @Column(name = "nationality")
    private String nationality;
}
