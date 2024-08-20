package EcommerceLibrary.Repository;

import EcommerceLibrary.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
