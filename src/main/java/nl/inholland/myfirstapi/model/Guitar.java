package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "guitar_seq", initialValue = 1_000_0001)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Guitar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guitar_seq")
    private long id;
    @ManyToOne
    @JsonBackReference
    private Brand brand;
    private String model;
    private Double price;

    public Guitar() {
    }

    public Guitar(Brand brand, String model, Double price) {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
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
        final StringBuffer sb = new StringBuffer("Guitar{");
        sb.append("id=").append(id);
        sb.append(", brand=").append(brand);
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
