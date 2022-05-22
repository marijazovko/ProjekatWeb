package vezbe.demo.service;

import org.hibernate.id.uuid.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.repository.KorisnikRepository;
import vezbe.demo.repository.KupacRepository;

import javax.xml.crypto.Data;
import java.util.*;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;


    public Korisnik login(String korisnickoIme, String lozinka) {
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(korisnickoIme);
        if(korisnik == null || !korisnik.getLozinka().equals(lozinka))
            return null;
        return  korisnik;
    }

    public String promenaKorisnika(KorisnikDto korisnikDto, Korisnik prijavljeniKorisnik){
        prijavljeniKorisnik.setLozinka(korisnikDto.getLozinka());
        prijavljeniKorisnik.setIme(korisnikDto.getIme());
        prijavljeniKorisnik.setPrezime(korisnikDto.getPrezime());
        prijavljeniKorisnik.setPol(korisnikDto.getPol());
        prijavljeniKorisnik.setDatumRodjenja(korisnikDto.getDatumRodjenja());

        if (korisnikDto.getKorisnickoIme().equals(prijavljeniKorisnik.getKorisnickoIme())){

            return "Korisnicko ime je zauzeto! Probajte ponovo!";
        }
        prijavljeniKorisnik.setKorisnickoIme(korisnikDto.getKorisnickoIme());

        korisnikRepository.save(prijavljeniKorisnik);
            return prijavljeniKorisnik.toString();
    }

    public String ispisKorisnika( Korisnik prijavljeniKorisnik){
       return prijavljeniKorisnik.toString();
    }
    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
}
