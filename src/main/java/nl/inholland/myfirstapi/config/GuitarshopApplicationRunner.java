package nl.inholland.myfirstapi.config;

import lombok.extern.java.Log;
import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.model.Stock;
import nl.inholland.myfirstapi.service.BrandService;
import nl.inholland.myfirstapi.service.GuitarService;
import nl.inholland.myfirstapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Log
@Transactional
public class GuitarshopApplicationRunner implements ApplicationRunner {

    @Autowired
    private GuitarService guitarService;
    @Autowired
    private StockService stockService;

    @Autowired
    private BrandService brandService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Brand fender = new Brand("Fender");
        brandService.addBrand(fender);
        Guitar guitar = new Guitar(fender, "Stratocaster", 1750.00);
        Stock stock = new Stock(guitar, 20);

        guitarService.addGuitar(guitar);
        stockService.addStock(stock);

        Guitar telecaster = new Guitar(fender, "Telecaster", 1600.00);
        Stock telecasterStock = new Stock(telecaster,50);

        guitarService.addGuitar(telecaster);
        stockService.addStock(telecasterStock);

        guitarService.getGuitars().forEach(System.out::println);

        stockService.getAllStocks().forEach(
                System.out::println
        );
    }
}
