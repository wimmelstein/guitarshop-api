package nl.inholland.guitarshopapi.dao;

import nl.inholland.guitarshopapi.model.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuitarRepository extends CrudRepository<Guitar, Long> {

    List<Guitar> getAllByPriceGreaterThanEqualOrderById(double value);
}
