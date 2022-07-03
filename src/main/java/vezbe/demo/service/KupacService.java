package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.model.Porudzbina;
import vezbe.demo.repository.KorisnikRepository;
import vezbe.demo.repository.KupacRepository;

import java.util.Properties;
import java.util.Set;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;


    public Kupac save(Kupac kupac){
        return kupacRepository.save(kupac);
    }

    public String registracija(RegistracijaDto registracijaDto) {
        Kupac kupac = new Kupac();

        kupac.setLozinka(registracijaDto.getLozinka());
        kupac.setIme(registracijaDto.getIme());
        kupac.setPrezime(registracijaDto.getPrezime());
        kupac.setPol(registracijaDto.getPol());
        kupac.setDatumRodjenja(registracijaDto.getDatumRodjenja());
        kupac.setUloga(Korisnik.Uloga.KUPAC);

        Korisnik temp = korisnikRepository.getByKorisnickoIme(registracijaDto.getKorisnickoIme());

        if(temp == null || registracijaDto.getKorisnickoIme().equals(kupac.getKorisnickoIme())){
            kupac.setKorisnickoIme(registracijaDto.getKorisnickoIme());
            korisnikRepository.save(kupac);
            return "Uspesna registracija!";
        }
        return "Korisnicko ime vec postoji";
    }

}
