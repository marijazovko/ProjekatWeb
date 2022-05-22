package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.StavkaPorudzbine;

@Repository
public interface StavkaPorudzbineRepository extends JpaRepository <StavkaPorudzbine, Long> {
}
