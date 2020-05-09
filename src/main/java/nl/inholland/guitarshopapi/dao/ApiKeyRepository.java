package nl.inholland.guitarshopapi.dao;

import nl.inholland.guitarshopapi.model.ApiKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository extends CrudRepository<ApiKey, String> {
}
