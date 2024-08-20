package EcommerceLibrary.Repository;

import EcommerceLibrary.Entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
