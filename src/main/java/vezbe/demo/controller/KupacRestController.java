package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.service.KupacService;

@RestController
public class KupacRestController {

    @Autowired
    private KupacService kupacService;

    @PostMapping("/registracija")
    public String registraija(@RequestBody RegistracijaDto registracijaDto) {
        Kupac kupac = new Kupac();

        kupac.setKorisnickoIme(registracijaDto.getKorisnickoIme());
        kupac.setLozinka(registracijaDto.getLozinka());
        kupac.setIme(registracijaDto.getIme());
        kupac.setPrezime(registracijaDto.getPrezime());
        kupac.setPol(registracijaDto.getPol());
        kupac.setDatumRodjenja(registracijaDto.getDatumRodjenja());
        kupac.setUloga(Korisnik.Uloga.KUPAC);

        this.kupacService.save(kupac);
        return "Uspesna registracija!";
    }
}
