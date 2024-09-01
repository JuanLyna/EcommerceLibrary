package EcommerceLibrary.Controller;

import EcommerceLibrary.Entities.Author;
import EcommerceLibrary.Entities.Book;
import EcommerceLibrary.Repository.AuthorRepository;
import EcommerceLibrary.Repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    BookRepository repository ;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findOneByID(@PathVariable Long id){
        Optional<Book> authorOptional= repository.findById(id); //Optional una estructura (encapsula al objeto) que indica si está presente o no el objeto
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/book/")
    public Book create(@RequestBody Book book){
        return repository.save( book);
    }
    @PutMapping("book/{id}") ResponseEntity<Book> update(@PathVariable  Book book){
        if(book.getId() == null){
            System.out.println("No existe libro");
            return ResponseEntity.badRequest().build();
        }

        Book result= repository.save(book);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("book/{id}")

    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
