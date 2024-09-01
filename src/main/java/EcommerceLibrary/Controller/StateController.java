package EcommerceLibrary.Controller;

import EcommerceLibrary.Entities.State;
import EcommerceLibrary.Repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StateController {
    StateRepository repository ;

    public StateController(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<State> findOneByID(@PathVariable Long id){
        Optional<State> authorOptional= repository.findById(id); //Optional una estructura (encapsula al objeto) que indica si está presente o no el objeto
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/state/")
    public State create(@RequestBody State state){
        return repository.save( state);
    }
    @PutMapping("state/{id}") ResponseEntity<State> update(@PathVariable  State state){
        if(state.getId() == null){
            System.out.println("No existe genero");
            return ResponseEntity.badRequest().build();
        }

        State result= repository.save(state);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("state/{id}")

    public ResponseEntity<State> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
