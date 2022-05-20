package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Korisnik;
import vezbe.demo.repository.KorisnikRepository;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik login(String username, String password) {
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(username);
        if(korisnik == null || !korisnik.getLozinka().equals(password))
            return null;
        return  korisnik;
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }
}
