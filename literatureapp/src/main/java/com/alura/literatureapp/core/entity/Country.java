package com.alura.literatureapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "iso_code")
    private String isoCode;
}
