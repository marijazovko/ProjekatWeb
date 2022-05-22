package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Korisnik;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository <Korisnik, Long> {
    Korisnik getByKorisnickoIme(String korisnickoIme);

}

