package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.GuitarRepository;
import nl.inholland.guitarshopapi.dao.StockRepository;
import nl.inholland.guitarshopapi.model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {

  @Autowired
  private GuitarRepository guitarRepository;

  @Autowired
  private StockRepository stockRepository;

  public GuitarService() {
  }

  public List<Guitar> getAllGuitars() {
    return (List<Guitar>) guitarRepository.findAll();
  }

  public Guitar getGuitarById(long id) {
    return guitarRepository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

  public void addGuitar(Guitar guitar) {
    guitarRepository.save(guitar);
    System.out.println(guitar);
  }

  public int valueByGuitarId(long id) {
    return stockRepository.getStockValueByGuitarId(id);
  }
}
