package nl.inholland.guitarshopapi.dao;

import nl.inholland.guitarshopapi.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantity(int minimum);

    @Query("select s.quantity * g.price from Stock s, Guitar g where s.guitar.id = g.id and s.guitar.id = ?1")
    int getStockValueByGuitarId(Long id);
}
