package nl.inholland.myfirstapi.repository;

import nl.inholland.myfirstapi.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
