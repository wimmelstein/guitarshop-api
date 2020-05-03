package nl.inholland.guitarshopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 50000001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    //TODO: Fix Delete
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="guitar_id")
    private Guitar guitar;

    public Stock() {
    }

    public Stock(int quantity, Guitar guitar) {
        this.quantity = quantity;
        this.guitar = guitar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", guitar=").append(guitar);
        sb.append('}');
        return sb.toString();
    }
}
