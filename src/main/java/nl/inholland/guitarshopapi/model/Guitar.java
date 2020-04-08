package nl.inholland.guitarshopapi.model;

public class Guitar {

  private long id;
  private String brand;
  private String model;
  private double price;

  public Guitar(long id, String brand, String model, double price ) {
    this.id = id;
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
