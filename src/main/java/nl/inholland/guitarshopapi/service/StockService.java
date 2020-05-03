package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.StockRepository;
import nl.inholland.guitarshopapi.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

  @Autowired
  private StockRepository stockRepository;

  public List<Stock> getAllStocks() {
    System.out.println("In service");
    return (List<Stock>) stockRepository.findAll();
  }
}
