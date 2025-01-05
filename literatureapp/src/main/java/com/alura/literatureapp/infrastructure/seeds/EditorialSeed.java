package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.entity.Country;
import com.alura.literatureapp.core.entity.Editorial;
import com.alura.literatureapp.core.repository.CountryRepository;
import com.alura.literatureapp.core.repository.EditorialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditorialSeed {


     CommandLineRunner initEditorials(EditorialRepository editorialRepository, CountryRepository countryRepository) {
        return args -> {
            if (editorialRepository.count() > 0) {
                System.out.println("Editorials already initialized. Skipping seed.");
                return;
            }

            Country mexico = countryRepository.findByIsoCode("MX")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'MX' not found"));
            Country spain = countryRepository.findByIsoCode("ES")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'ES' not found"));

            Country argentina = countryRepository.findByIsoCode("AR")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'AR' not found"));


            Editorial editorial1 = Editorial.builder()
                    .name("Editorial Planeta")
                    .country(mexico)
                    .build();

            Editorial editorial2 = Editorial.builder()
                    .name("Penguin")
                    .country(spain)
                    .build();

            Editorial editorial3 = Editorial.builder()
                    .name("Bloomsbury")
                    .country(argentina)
                    .build();


            editorialRepository.saveAll(List.of(editorial1, editorial2, editorial3));

            System.out.println("Editorials initialized successfully.");
        };
    }
}
