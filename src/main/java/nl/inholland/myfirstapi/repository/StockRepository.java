package nl.inholland.myfirstapi.repository;

import nl.inholland.myfirstapi.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    int getStockValueByGuitarId(long id);
}
