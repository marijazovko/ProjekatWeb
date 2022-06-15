package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.ArtikalService;
import vezbe.demo.service.KorisnikService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private ArtikalService artikalService;

    @PostMapping("/prijava")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Nevazeci podaci!", HttpStatus.BAD_REQUEST);

        Korisnik prijavljenKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if (prijavljenKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", prijavljenKorisnik);
        return ResponseEntity.ok("Uspesno prijavljivanje!");
    }

    @PostMapping("/odjava")
    public ResponseEntity Logout(HttpSession session){
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik == null)
            return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesna odjava!", HttpStatus.OK);
    }

    @PostMapping("/promena")
    public ResponseEntity<String> izmenaProfila(@RequestBody KorisnikDto korisnikDto, HttpSession session){
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");
        String odgovor =korisnikService.promenaKorisnika(korisnikDto, prijavljenKorisnik);
        return ResponseEntity.ok(odgovor);
    }

    @GetMapping("/ispis")//JSOon
    public ResponseEntity<String> ispisProfila( HttpSession session){
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");
        String odgovor =korisnikService.ispisKorisnika(prijavljenKorisnik);

        return ResponseEntity.ok(odgovor);
    }


}
