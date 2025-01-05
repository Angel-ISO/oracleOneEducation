package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.core.entity.Languaje;
import com.alura.literatureapp.core.repository.LanguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguajeService extends GenericService<Languaje, Long> {

    @Autowired
    public LanguajeService(LanguajeRepository languajeRepository) {
        super(languajeRepository);
    }
}
