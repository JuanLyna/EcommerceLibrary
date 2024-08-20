package EcommerceLibrary.Repository;

import EcommerceLibrary.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long > {

}
