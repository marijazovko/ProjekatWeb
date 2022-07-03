package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.MenadzerRepository;

import java.util.Optional;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;

    public Menadzer save(Menadzer menadzer){
        return menadzerRepository.save(menadzer);
    }

    public String kreiranjeMenadzera(RegistracijaDto registracijaDto){
        Menadzer menadzer = new Menadzer();

        menadzer.setKorisnickoIme(registracijaDto.getKorisnickoIme());
        menadzer.setLozinka(registracijaDto.getLozinka());
        menadzer.setIme(registracijaDto.getIme());
        menadzer.setPrezime(registracijaDto.getPrezime());
        menadzer.setPol(registracijaDto.getPol());
        menadzer.setDatumRodjenja(registracijaDto.getDatumRodjenja());
        menadzer.setUloga(Korisnik.Uloga.MENADZER);

        save(menadzer);

        return null;
    }

    public Restoran findRestoran(Korisnik prijavljenKorisnik) {
        Menadzer temp = menadzerRepository.getById(prijavljenKorisnik.getId());
        return temp.getRestoran();
    }

    public Menadzer findOne(String korisnickoIme) {
        Optional<Menadzer> foundMenadzer = menadzerRepository.findByKorisnickoIme(korisnickoIme);
        return foundMenadzer.orElse(null);
    }
}
