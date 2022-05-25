package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Dostavljac;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.repository.DostavljacRepository;

@Service
public class DostavljacService {

    @Autowired
    private DostavljacRepository dostavljacRepository;

    public Dostavljac save(Dostavljac dostavljac){
        return dostavljacRepository.save(dostavljac);
    }

    public String kreiranjeDostavljaca (RegistracijaDto registracijaDto) {
        Dostavljac dostavljac = new Dostavljac();

        dostavljac.setKorisnickoIme(registracijaDto.getKorisnickoIme());
        dostavljac.setLozinka(registracijaDto.getLozinka());
        dostavljac.setIme(registracijaDto.getIme());
        dostavljac.setPrezime(registracijaDto.getPrezime());
        dostavljac.setPol(registracijaDto.getPol());
        dostavljac.setDatumRodjenja(registracijaDto.getDatumRodjenja());
        dostavljac.setUloga(Korisnik.Uloga.DOSTAVLJAC);

        save(dostavljac);

        return null;
    }
}
