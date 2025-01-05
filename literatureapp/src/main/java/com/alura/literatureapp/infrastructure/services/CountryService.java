package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.core.entity.Country;
import com.alura.literatureapp.core.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country, Long> {

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
    }
}
