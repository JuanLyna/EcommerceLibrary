package EcommerceLibrary.Entities;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name= "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //merge significa que si actualizamos el objeto padre en la base de datos, entonces se debe hacer lo mismo con sus objetos dependientes
    @JoinTable(name= "author_genders", joinColumns = @JoinColumn(name="AUTHOR_ID",referencedColumnName = "id"),inverseJoinColumns =  @JoinColumn(name="GENDER_ID",referencedColumnName = "id"))
    private List<Gender> genderlist;
    @ManyToOne
    @JoinColumn(name = "ID_STATE")
    private State current;
    String nationality;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL , orphanRemoval = true)
    //mappedBy= author: author es el  nombre del atributo en la clase Book, esto para que JPA determine que libros se almacenarán en la lista "books"  de Author
    //orphanRemoval = true significa que si libro pierde la referencia a author, esté se eliminará de la base de datos (xq no existe en nuestra lógica de empresa un libro sin autor(

    //cascade = CascadeType.ALL si se borra el autor, se borran todos los libros.
    //@JoinColumn(name= )
    private List<Book> books=new ArrayList<>();

    private Date birth;

    public Author() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Author(String name, String lastName, int age, List<Gender> genderlist, State current, String nationality, List<Book> books, Date birth) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.genderlist = genderlist;
        this.current = current;
        this.nationality = nationality;
        this.books = books;
        this.birth = birth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Gender> getGenderlist() {
        return genderlist;
    }

    public void setGenderlist(List<Gender> genderlist) {
        this.genderlist = genderlist;
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
