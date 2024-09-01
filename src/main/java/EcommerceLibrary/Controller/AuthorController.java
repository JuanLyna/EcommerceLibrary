package EcommerceLibrary.Controller;

import EcommerceLibrary.Entities.Author;
import EcommerceLibrary.Repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorController {

    final private AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> findOneByID(@PathVariable Long id){
        Optional<Author> authorOptional= repository.findById(id); //Optional una estructura (encapsula al objeto) que indica si está presente o no el objeto
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
    @PostMapping("/author/")
    public Author create(@RequestBody  Author author){
        return repository.save( author);
    }
    @PutMapping("author/{id}") ResponseEntity<Author> update(@PathVariable  Author author){
        if(author.getId() == null){
            System.out.println("No existe author");
            return ResponseEntity.badRequest().build();
        }

       Author result= repository.save(author);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("author/{id}")

    public ResponseEntity<Author> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
