package EcommerceLibrary.Controller;


import EcommerceLibrary.Entities.Gender;
import EcommerceLibrary.Repository.GenderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GenderController {
    GenderRepository repository ;

    public GenderController(GenderRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/gender/{id}")
    public ResponseEntity<Gender> findOneByID(@PathVariable Long id){
        Optional<Gender> authorOptional= repository.findById(id); //Optional una estructura (encapsula al objeto) que indica si está presente o no el objeto
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/Gender/")
    public Gender create(@RequestBody Gender gender){
        return repository.save( gender);
    }
    @PutMapping("gender/{id}") ResponseEntity<Gender> update(@PathVariable  Gender gender){
        if(gender.getId() == null){
            System.out.println("No existe genero");
            return ResponseEntity.badRequest().build();
        }

        Gender result= repository.save(gender);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("gender/{id}")

    public ResponseEntity<Gender> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
