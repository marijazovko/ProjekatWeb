package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.service.MenadzerService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;

@RestController
public class MenadzerRestController {

    @Autowired
    private MenadzerService menadzerService;

    @PostMapping("/kreiranjeMenadzera")
    public String kreiranjeMenadzera(@RequestBody RegistracijaDto registracijaDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            this.menadzerService.kreiranjeMenadzera(registracijaDto);
            return "Uspesno kreiranje Menadzera!";
        }
        return "Nemate pravo na kreiranje Menadzera!";
    }
}
