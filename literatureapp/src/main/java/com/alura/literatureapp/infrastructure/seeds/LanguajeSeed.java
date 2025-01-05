package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.entity.Country;
import com.alura.literatureapp.core.entity.Languaje;
import com.alura.literatureapp.core.repository.CountryRepository;
import com.alura.literatureapp.core.repository.LanguajeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguajeSeed {


     CommandLineRunner initLanguajes(LanguajeRepository languajeRepository, CountryRepository countryRepository) {
        return args -> {
            if (languajeRepository.count() > 0) {
                System.out.println("Languages already initialized. Skipping seed.");
                return;
            }

            Country country1 = countryRepository.findByIsoCode("AR")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'AR' not found"));
            Country country2 = countryRepository.findByIsoCode("ES")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'ES' not found"));
            Country country3 = countryRepository.findByIsoCode("US")
                    .orElseThrow(() -> new RuntimeException("Country with ISO code 'US' not found"));

            if (country1 == null || country2 == null || country3 == null) {
                System.out.println("One or more countries not found. Skipping languaje seeding.");
                return;
            }

            Languaje languaje1 = Languaje.builder()
                    .name("SpanishArgentina")
                    .country(country1)
                    .build();

            Languaje languaje2 = Languaje.builder()
                    .name("SpanishEspana")
                    .country(country2)
                    .build();

            Languaje languaje3 = Languaje.builder()
                    .name("EnglishUnitedStates")
                    .country(country3)
                    .build();



            languajeRepository.saveAll(List.of(languaje1, languaje2));

            System.out.println("Languajes initialized successfully.");
        };
    }
}
