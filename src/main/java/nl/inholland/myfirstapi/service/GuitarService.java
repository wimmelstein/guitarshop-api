package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuitarService {

    private List<Guitar> guitars = new ArrayList<>();

    public GuitarService() {
        this.guitars = new ArrayList<>(
                List.of(
                        new Guitar("Fender", "Stratocaster", 1650.00),
                        new Guitar("Fender", "Telecaster", 2100.00),
                        new Guitar("Gibson", "Firebird", 3999.99)
                )
        );
    }

    public Guitar createGuitar(Guitar guitar) {
        guitars.add(guitar);
        return guitar;
    }
    public List<Guitar> getGuitars() {
        return guitars;
    }
}
