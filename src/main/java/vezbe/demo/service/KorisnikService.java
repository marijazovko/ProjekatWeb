package vezbe.demo.service;

import org.hibernate.id.uuid.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.model.Menadzer;
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

    public String ispisProfila (Korisnik prijavljenKorisnik){

        KorisnikService korisnikService = new KorisnikService();

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)){

            List<Korisnik> korisnikList = korisnikService.findAll();

            List<KorisnikDto> dtos = new ArrayList<>();
            for(Korisnik korisnik : korisnikList){
                KorisnikDto dto = new KorisnikDto(korisnik);
                dtos.add(dto);
            }
        }
        return null;
    }

    public String promenaKorisnika(KorisnikDto korisnikDto, Korisnik prijavljeniKorisnik){
        prijavljeniKorisnik.setLozinka(korisnikDto.getLozinka());
        prijavljeniKorisnik.setIme(korisnikDto.getIme());
        prijavljeniKorisnik.setPrezime(korisnikDto.getPrezime());
        prijavljeniKorisnik.setPol(korisnikDto.getPol());
        prijavljeniKorisnik.setDatumRodjenja(korisnikDto.getDatumRodjenja());

        Korisnik temp = korisnikRepository.getByKorisnickoIme(korisnikDto.getKorisnickoIme());

        if(temp == null || korisnikDto.getKorisnickoIme().equals(prijavljeniKorisnik.getKorisnickoIme())){
            prijavljeniKorisnik.setKorisnickoIme(korisnikDto.getKorisnickoIme());
            korisnikRepository.save(prijavljeniKorisnik);
            return "Uspesna izmena podataka!";
        }
        return "Korisnicko ime vec postoji!";

    }

    public String ispisKorisnika( Korisnik prijavljeniKorisnik){
       return prijavljeniKorisnik.toString();
    }
    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

}
