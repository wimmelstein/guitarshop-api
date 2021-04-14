package nl.inholland.myfirstapi.model;

import java.util.UUID;

public class Guitar {

    private UUID uuid;
    private String brand;
    private String model;
    private Double price;

    public Guitar(String brand, String model, Double price) {
        this.uuid = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "uuid=" + uuid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
