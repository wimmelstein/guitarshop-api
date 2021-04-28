package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Stock;
import nl.inholland.myfirstapi.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepository.findAll();
    }

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }
}
