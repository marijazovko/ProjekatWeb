package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Restoran;

import java.util.Optional;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {
    Optional<Restoran> findById(Long id);

}
