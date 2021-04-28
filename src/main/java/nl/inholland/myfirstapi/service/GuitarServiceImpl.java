package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.repository.GuitarRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GuitarServiceImpl implements GuitarService{

    @Autowired
    private GuitarRepository guitarRepository;

    public Guitar addGuitar(Guitar guitar) {
        guitarRepository.save(guitar);
        return guitar;
    }
    public List<Guitar> getGuitars() {
        return (List<Guitar>) guitarRepository.findAll();
    }
}
