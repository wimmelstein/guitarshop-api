package nl.inholland.guitarshopapi.configuration;

import nl.inholland.guitarshopapi.dao.GuitarRepository;
import nl.inholland.guitarshopapi.dao.StockRepository;
import nl.inholland.guitarshopapi.dao.UserRepository;
import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.model.GuitarshopUserDetails;
import nl.inholland.guitarshopapi.model.Stock;
import nl.inholland.guitarshopapi.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@ConditionalOnProperty(prefix = "guitarshop.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MyApplicationRunner implements ApplicationRunner {

  private GuitarRepository guitarRepository;
  private StockRepository stockRepository;
  private PropertyConfiguration properties;
  private UserRepository userRepository;

  public MyApplicationRunner(GuitarRepository guitarRepository, StockRepository stockRepository, PropertyConfiguration properties, UserRepository userRepository) {
    this.guitarRepository = guitarRepository;
    this.stockRepository = stockRepository;
    this.properties = properties;
    this.userRepository = userRepository;
  }

  @Value( "${guitarshop.default.quantity}")
  private int defaultQuantity;

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

    System.out.println("Default quantity " + defaultQuantity);

    System.out.println("Application name: " + properties.getApplicationName());

    User user = new User("wimmel", new BCryptPasswordEncoder().encode("password"), "ADMIN");
    userRepository.save(user);
    userRepository.findAll().forEach(System.out::println);

    GuitarshopUserDetails userDetails = new GuitarshopUserDetails(user);
    System.out.println(userDetails.getPassword());
  }
}
