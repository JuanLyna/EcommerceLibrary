package EcommerceLibrary.Controller;

import EcommerceLibrary.Model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
