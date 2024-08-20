package EcommerceLibrary.Controller;

import EcommerceLibrary.Repository.BookRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    BookRepository repository ;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }
}
