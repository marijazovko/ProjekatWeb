package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Dostavljac;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.DostavljacService;

import javax.servlet.http.HttpSession;

@RestController
public class DostavljacRestController {

    @Autowired
    private DostavljacService dostavljacService;

    @PostMapping("/kreiranjeDostavljaca")
    public String kreiranjeDostavljaca(@RequestBody RegistracijaDto registracijaDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            this.dostavljacService.kreiranjeDostavljaca(registracijaDto);
            return "Uspesno kreiranje Dostavljaca!";
        }
        return "Nemate pravo na kreiranje Dostavljaca!";
    }
}
