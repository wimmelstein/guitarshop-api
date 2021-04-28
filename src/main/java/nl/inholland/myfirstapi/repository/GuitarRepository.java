package nl.inholland.myfirstapi.repository;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends CrudRepository<Guitar, Long> {
}
