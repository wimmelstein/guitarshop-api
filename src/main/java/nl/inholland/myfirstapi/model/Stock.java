package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "stock_seq", initialValue = 5_000_000)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "guitar_id")
    private Guitar guitar;
    private int quantity;

    public Stock() {
    }

    public Stock(Guitar guitar, int quantity) {
        this.guitar = guitar;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("id=").append(id);
        sb.append(", guitar=").append(guitar);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
