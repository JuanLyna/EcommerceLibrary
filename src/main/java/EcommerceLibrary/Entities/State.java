package EcommerceLibrary.Entities;


import jakarta.persistence.*;


@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String name;

    public State(String name) {
        this.name = name;
    }

    public State() {

    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
