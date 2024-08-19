package EcommerceLibrary.Controller;

import EcommerceLibrary.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
