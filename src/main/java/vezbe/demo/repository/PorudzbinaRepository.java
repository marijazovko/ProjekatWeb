package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vezbe.demo.model.Porudzbina;

import java.util.UUID;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, UUID> {
}
