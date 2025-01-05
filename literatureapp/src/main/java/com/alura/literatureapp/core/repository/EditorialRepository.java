package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Editorial;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorialRepository extends BaseRepository<Editorial, Long> {

    Optional<Editorial> findByName(String name);
}
