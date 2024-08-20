package EcommerceLibrary.Entities;

import jakarta.persistence.*;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;

    public Gender(String name) {
        this.name = name;
    }

    public Gender() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
