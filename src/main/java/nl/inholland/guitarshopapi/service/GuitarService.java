package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.model.Guitar;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GuitarService {

  List<Guitar> guitars;

  public GuitarService() {

    this.guitars =  Arrays.asList(
        new Guitar(1L,"Fender", "Stratocaster"),
        new Guitar(2l, "Fender", "Telecaster"),
        new Guitar(3L, "Gibson", "Les Paul")
    );
  }

  public List<Guitar> getAllGuitars() {
    return guitars;
  }


}
