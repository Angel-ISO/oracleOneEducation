package com.alura.literatureapp.infrastructure.services;

import com.alura.literatureapp.core.entity.Editorial;
import com.alura.literatureapp.core.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService extends GenericService<Editorial, Long> {

    @Autowired
    public EditorialService(EditorialRepository editorialRepository) {
        super(editorialRepository);
    }

}
