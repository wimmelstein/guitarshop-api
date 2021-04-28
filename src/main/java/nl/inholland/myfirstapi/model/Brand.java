package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "brand_seq", initialValue = 9_000_000)
public class Brand {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    private long id;
    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "brand")
    private Set<Guitar> guitars = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<Guitar> guitars) {
        this.guitars = guitars;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Brand{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", guitars=").append(guitars);
        sb.append('}');
        return sb.toString();
    }
}
