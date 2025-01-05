package com.alura.literatureapp.infrastructure.seeds;

import com.alura.literatureapp.core.entity.Country;
import com.alura.literatureapp.core.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountrySeed {

     CommandLineRunner initCountries(CountryRepository countryRepository) {
        return args -> {
            if (countryRepository.count() > 0) {
                System.out.println("Countries already initialized. Skipping seed.");
                return;
            }

            Country mexico = Country.builder()
                    .name("Mexico")
                    .isoCode("MX")
                    .build();

            Country spain = Country.builder()
                    .name("Spain")
                    .isoCode("ES")
                    .build();

            Country argentina = Country.builder()
                    .name("Argentina")
                    .isoCode("AR")
                    .build();

            Country colombia = Country.builder()
                    .name("Colombia")
                    .isoCode("CO")
                    .build();

            Country UnitedStates = Country.builder()
                    .name("United States")
                    .isoCode("US")
                    .build();

            countryRepository.saveAll(List.of(mexico, spain, argentina, colombia, UnitedStates));

            System.out.println("Countries initialized successfully.");
        };
    }
}
