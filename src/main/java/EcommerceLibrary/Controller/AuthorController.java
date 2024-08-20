package EcommerceLibrary.Controller;

import EcommerceLibrary.Repository.AuthorRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }
}
