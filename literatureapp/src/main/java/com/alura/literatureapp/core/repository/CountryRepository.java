package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends BaseRepository<Country, Long> {

    Optional<Country> findByIsoCode(String isoCode);

}
