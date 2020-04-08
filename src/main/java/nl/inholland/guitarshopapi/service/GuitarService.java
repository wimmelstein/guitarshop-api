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
        new Guitar(1L,"Fender" , "Stratocaster", 1499.00),
        new Guitar(2l, "Fender", "Telecaster", 1299.00),
        new Guitar(3L, "Gibson", "Les Paul",2499.00)
    );
  }

  public List<Guitar> getAllGuitars() {
    return guitars;
  }


}
