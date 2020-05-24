package nl.inholland.guitarshopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"brand", "model"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Guitar {

  @Id
  @SequenceGenerator(name = "guitar_seq", initialValue = 1000001, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq")
  private long id;
  private String brand;
  private String model;
  private double price;

  public Guitar() {
  }

  public Guitar(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
  }

  public void setPrice(double price) {
    if (price < 0) throw new IllegalArgumentException("Price cannot be below zero");
    this.price = price;
  }
}
