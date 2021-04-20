package nl.inholland.guitarshopapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private long id;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "brand")
    private Set<Guitar> guitars = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<Guitar> guitars) {
        this.guitars = guitars;
    }
}
