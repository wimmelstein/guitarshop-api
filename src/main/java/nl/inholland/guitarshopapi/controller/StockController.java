package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Stock;
import nl.inholland.guitarshopapi.service.StockService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "stocks")
public class StockController {

  private StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllStocks() {
    try {
      List<Stock> stocks = stockService.getAllStocks();
      System.out.println("In controller");
      stocks.forEach(System.out::println);
      return ResponseEntity.status(200).body(stocks);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }

  }
}
