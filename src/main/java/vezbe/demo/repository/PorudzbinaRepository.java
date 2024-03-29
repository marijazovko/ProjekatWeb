package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Porudzbina;

import java.util.UUID;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, UUID> {
}
