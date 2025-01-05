package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Languaje;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguajeRepository extends BaseRepository<Languaje, Long> {

    Optional<Languaje> findByName(String name);
}
