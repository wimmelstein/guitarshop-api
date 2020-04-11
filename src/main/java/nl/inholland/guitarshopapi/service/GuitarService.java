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
        new Guitar(1L,"Fender", "Telecaster", 899),
        new Guitar(2l, "Fender", "Stratcaster", 1299),
        new Guitar(3L, "Gibson", "Les Paul", 2999)
    );
  }

  public List<Guitar> getAllGuitars() {
    return guitars;
  }


}
