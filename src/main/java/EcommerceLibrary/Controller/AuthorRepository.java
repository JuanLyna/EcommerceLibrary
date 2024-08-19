package EcommerceLibrary.Controller;

import EcommerceLibrary.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long > {

}
