package nl.inholland.guitarshopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"brand", "model"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Guitar {

  @Id
  @SequenceGenerator(name = "guitar_seq", initialValue = 1000001)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq")
  private long id;
  private String brand;
  private String model;
  private double price;

  @OneToOne(mappedBy = "guitar", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="guitar_id")
  private Stock stock;

  public Guitar() {
  }

  public Guitar(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    if (price < 0) throw new IllegalArgumentException("Price cannot be below zero");
    this.price = price;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Guitar{");
    sb.append("id=").append(id);
    sb.append(", brand='").append(brand).append('\'');
    sb.append(", price=").append(price);
    sb.append(", model='").append(model).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
