package EcommerceLibrary.Controller;

import EcommerceLibrary.Repository.StateRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {
    StateRepository repository ;

    public StateController(StateRepository repository) {
        this.repository = repository;
    }
}
