package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.ArtikalDto;
import vezbe.demo.model.Artikal;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.service.ArtikalService;

import javax.servlet.http.HttpSession;

@RestController
public class ArtikalRestController {

    @Autowired
    private ArtikalService artikalService;

    @PostMapping("/dodavanjeArtikala")
    public ResponseEntity dodavanjeArtikala(@RequestBody ArtikalDto artikalDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.MENADZER)) {
            this.artikalService.dodavanjeArtikala(artikalDto, prijavljenKorisnik);
            return new ResponseEntity("Uspesno dodavanje artikla!", HttpStatus.OK);
        }
        return new ResponseEntity("Nemate pravo na dodavanje artikla!", HttpStatus.FORBIDDEN);
    }

}
