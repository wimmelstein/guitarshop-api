package nl.inholland.guitarshopapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class ApiKey {

  @Id
  private String key;

  public ApiKey(String key) {
    this.key = key;
  }
}
