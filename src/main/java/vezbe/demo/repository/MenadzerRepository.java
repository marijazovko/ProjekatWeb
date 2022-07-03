package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Menadzer;

import java.util.Optional;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer, Long> {
    public Menadzer getById(Long id);

    Optional<Menadzer> findByKorisnickoIme(String korisnickoIme);
}
