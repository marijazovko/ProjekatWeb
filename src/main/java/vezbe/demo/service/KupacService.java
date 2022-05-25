package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.repository.KupacRepository;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;

    public Kupac save(Kupac kupac){
        return kupacRepository.save(kupac);
    }

    public String registraija(RegistracijaDto registracijaDto) {
        Kupac kupac = new Kupac();

        kupac.setKorisnickoIme((registracijaDto.getKorisnickoIme()));
        kupac.setLozinka(registracijaDto.getLozinka());
        kupac.setIme(registracijaDto.getIme());
        kupac.setPrezime(registracijaDto.getPrezime());
        kupac.setPol(registracijaDto.getPol());
        kupac.setDatumRodjenja(registracijaDto.getDatumRodjenja());
        kupac.setUloga(Korisnik.Uloga.KUPAC);

        this.save(kupac);

        return null;
    }
}
