package EcommerceLibrary.Entities;

import jakarta.persistence.*;


import java.util.*;

@Entity
@Table(name= "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) //FetchType.LAZY carga los datos desde la base de datos cuando se llama a la entidad, necesario en esté caso para que no cargué datos basura
    @JoinColumn(name="AUTHOR_ID") //indica en que columa va a referenciar this.author
    private Author author;
    private String title;
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //merge significa que si actualizamos el objeto padre en la base de datos, entonces se debe hacer lo mismo con sus objetos dependientes
    @JoinTable(name= "books_genders", joinColumns = @JoinColumn(name="BOOK_ID",referencedColumnName = "id"),inverseJoinColumns =  @JoinColumn(name="GENDER_ID",referencedColumnName = "id"))

    private List<Gender>  genders= new ArrayList<Gender>() ;
    private Date release;
    @ManyToOne()
    @JoinColumn(name = "ID_STATE")
    private State current;
    private String desc;
    double price;

    public Book() {}

    public Book(Author author, String title, List<Gender> genders, Date release, State current, String desc, double price) {
        this.author = author;
        this.title = title;
        this.genders = genders;
        this.release = release;
        this.current = current;
        this.desc = desc;
        this.price = price;
    }

    public Book(String title, Author author, List<Gender> genders, Date release, State current) {
        this.title = title;
        this.author = author;
        this.genders = genders;
        this.release = release;
        this.current = current;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }
}
