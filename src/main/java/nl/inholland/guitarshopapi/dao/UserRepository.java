package nl.inholland.guitarshopapi.dao;

import nl.inholland.guitarshopapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
}
