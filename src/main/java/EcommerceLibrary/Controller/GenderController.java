package EcommerceLibrary.Controller;

import EcommerceLibrary.Repository.GenderRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {
    GenderRepository repository ;

    public GenderController(GenderRepository repository) {
        this.repository = repository;
    }
}
