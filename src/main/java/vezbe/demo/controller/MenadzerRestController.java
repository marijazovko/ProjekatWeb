package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.ArtikalDto;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Artikal;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.service.ArtikalService;
import vezbe.demo.service.MenadzerService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MenadzerRestController {

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private RestoranService restoranService;


    @PostMapping("/kreiranjeMenadzera")
    public ResponseEntity kreiranjeMenadzera(@RequestBody RegistracijaDto registracijaDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            this.menadzerService.kreiranjeMenadzera(registracijaDto);
            return new ResponseEntity("Uspesno kreiranje menadzera!", HttpStatus.OK);
        }
        return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/menadzer/restoran")
    public ResponseEntity<Restoran> getRestoran(HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik.getUloga() != Korisnik.Uloga.MENADZER) {
            return new ResponseEntity("Nemate pravo!", HttpStatus.FORBIDDEN);
        }

        Menadzer menadzer = menadzerService.findOne(loggedKorisnik.getKorisnickoIme());
        Restoran restoran = menadzer.getRestoran();
        Restoran restoran2 = new Restoran(restoran);

        if (restoran2 == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(restoran2);
    }

    @PostMapping("/izmenaArtikla/{id}")
    public ResponseEntity<String> izmenaArtikla (@RequestBody Artikal artikal, HttpSession session){
        Korisnik prijavljenKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(prijavljenKorisnik == null || prijavljenKorisnik.getUloga() != Korisnik.Uloga.MENADZER) {
            return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
        }

        String response = restoranService.promeniArtikal(artikal, prijavljenKorisnik);
        return ResponseEntity.ok(response);
    }
}

