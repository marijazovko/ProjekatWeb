package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.service.AdministratorService;
import vezbe.demo.service.RestoranService;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdministratorRestController {

    @Autowired
    AdministratorService administratorService;


    @GetMapping("/ispisSvihKorisnika")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session) {


        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {

            List<KorisnikDto> dtos = new ArrayList<>();
            this.administratorService.ispisSvihKorisnika(dtos);
            return ResponseEntity.ok(dtos);
        }
        return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
    }
    @PostMapping("/pretragaPoKorisnickomImenu")
    public ResponseEntity<List<KorisnikDto>> getKorisniciPoKorisnickomImenu(@RequestBody KorisnikDto korisnikDto, HttpSession session){


        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {


            List<KorisnikDto> dtos = new ArrayList<>();
            this.administratorService.pretragaPoKorisnickomImenu(dtos, korisnikDto);
            return ResponseEntity.ok(dtos);

        }
        return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
    }
    @PostMapping("/pretragaPoImenu")
    public ResponseEntity<List<KorisnikDto>> getKorisniciPoImenu(@RequestBody KorisnikDto korisnikDto, HttpSession session){

        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {


            List<KorisnikDto> dtos = new ArrayList<>();
            this.administratorService.pretragaPoImenu(dtos, korisnikDto);
            return ResponseEntity.ok(dtos);

        }
        return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
    }
    @PostMapping("/pretragaPoPrezimenu")
    public ResponseEntity<List<KorisnikDto>> getKorisniciPoPrezimenu(@RequestBody KorisnikDto korisnikDto, HttpSession session){


        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {


            List<KorisnikDto> dtos = new ArrayList<>();
            this.administratorService.pretragaPoPrezimenu(dtos, korisnikDto);
            return ResponseEntity.ok(dtos);

        }
        return new ResponseEntity("Zabranjeno!", HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/brisanjeRestorana/{id}")
    public ResponseEntity deleteRestoran(@PathVariable Long id) {
        administratorService.removeRestoran(id);
        String odgovor = "Uspesno brisanje!";
        return ResponseEntity.ok(odgovor);
    }
}
