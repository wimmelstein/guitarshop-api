package nl.inholland.guitarshopapi.configuration;

import nl.inholland.guitarshopapi.dao.GuitarRepository;
import nl.inholland.guitarshopapi.dao.StockRepository;
import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.model.Stock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@ConditionalOnProperty(prefix = "guitarshop.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
@Transactional
public class MyApplicationRunner implements ApplicationRunner {

  private GuitarRepository guitarRepository;
  private StockRepository stockRepository;

  public MyApplicationRunner(GuitarRepository guitarRepository, StockRepository stockRepository) {
    this.guitarRepository = guitarRepository;
    this.stockRepository = stockRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Guitar> guitars =
        Arrays.asList(
            new Guitar("Fender", "Telecaster", 899),
            new Guitar("Fender", "Stratcaster", 1299),
            new Guitar("Gibson", "Les Paul", 2999));

    guitars.forEach(guitarRepository::save);

    guitarRepository.findAll().forEach(System.out::println);

    guitarRepository
        .findAll()
        .forEach(guitar -> stockRepository.save(new Stock(new Random().nextInt(100), guitar)));

    stockRepository.findAll().forEach(System.out::println);

    Iterable<Stock> stocks = stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(30);
    stocks.forEach(System.out::println);

    int quantity = stockRepository.getStockValueByGuitarId(1000001L);
    System.out.println("Quantity: " + quantity);
  }
}
