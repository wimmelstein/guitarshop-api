package nl.inholland.guitarshopapi.dao;

import nl.inholland.guitarshopapi.model.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {

    Brand findBrandByName(String name);
}
