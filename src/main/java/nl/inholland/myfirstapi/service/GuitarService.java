package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;

import java.util.List;

public interface GuitarService {
    Guitar addGuitar(Guitar guitar);
    List<Guitar> getGuitars();
}
