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

    @PostMapping("/korisnik/prijava")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Nevazeci podaci!", HttpStatus.BAD_REQUEST);

        Korisnik prijavljenKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if (prijavljenKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", prijavljenKorisnik);
        return ResponseEntity.ok("Uspesno prijavljivanje!");
    }

    @PostMapping("korisnik/odjava")
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

    @GetMapping("/ispis")
    public ResponseEntity<String> ispisProfila( HttpSession session){
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");
        String odgovor =korisnikService.ispisKorisnika(prijavljenKorisnik);

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)){
            List<Korisnik> korisnikList = korisnikService.findAll();

            List<KorisnikDto> dtos = new ArrayList<>();
            for(Korisnik korisnik : korisnikList){
                KorisnikDto dto = new KorisnikDto(korisnik);
                dtos.add(dto);
            }
        }
        return ResponseEntity.ok(odgovor);
    }


    @PostMapping("/kreiranjeMenadzera")
    public String kreiranjeMenadzera(@RequestBody RegistracijaDto registracijaDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            Menadzer menadzer = new Menadzer();

            menadzer.setKorisnickoIme(registracijaDto.getKorisnickoIme());
            menadzer.setLozinka(registracijaDto.getLozinka());
            menadzer.setIme(registracijaDto.getIme());
            menadzer.setPrezime(registracijaDto.getPrezime());
            menadzer.setPol(registracijaDto.getPol());
            menadzer.setDatumRodjenja(registracijaDto.getDatumRodjenja());
            menadzer.setUloga(Korisnik.Uloga.MENADZER);

            this.korisnikService.save(menadzer);
            return "Uspesno kreiranje Menadzera!";
        }
        return "Nemate pravo na kreiranje Menadzera!";
    }

    @PostMapping("/kreiranjeDostavljaca")
    public String kreiranjeDostavljaca(@RequestBody RegistracijaDto registracijaDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            Dostavljac dostavljac = new Dostavljac();

            dostavljac.setKorisnickoIme(registracijaDto.getKorisnickoIme());
            dostavljac.setLozinka(registracijaDto.getLozinka());
            dostavljac.setIme(registracijaDto.getIme());
            dostavljac.setPrezime(registracijaDto.getPrezime());
            dostavljac.setPol(registracijaDto.getPol());
            dostavljac.setDatumRodjenja(registracijaDto.getDatumRodjenja());
            dostavljac.setUloga(Korisnik.Uloga.DOSTAVLJAC);

            this.korisnikService.save(dostavljac);
            return "Uspesno kreiranje Dostavljaca!";
        }
        return "Nemate pravo na kreiranje Dostavljaca!";
    }

    @PostMapping("/kreiranjeRestorana")
    public String kreiranjeRestorana(@RequestBody RestoranDto restoranDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            Restoran restoran = new Restoran();

            restoran.setNaziv(restoranDto.getNaziv());
            restoran.setTipRestorana(restoranDto.getTipRestorana());
            //restoran.setLokacija(restoranDto.getLokacija().getAdresa());

            this.restoranService.save(restoran);
            return "Uspesno kreiranje restorana!";
        }
        return "Nemate pravo na kreiranje restorana!";
    }

    @PostMapping("/dodavanjeArtikala")
    public String dodavanjeArtikala(@RequestBody ArtikalDto artikalDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.MENADZER)) {
            Menadzer menadzer = new Menadzer(prijavljenKorisnik);
            Artikal artikal = new Artikal();
            Restoran restoran =menadzer.getRestoran();

            artikal.setNaziv(artikalDto.getNaziv());
            artikal.setCena(artikalDto.getCena());
            artikal.setTipArtikla(artikalDto.getTipArtikla());
            artikal.setOpis(artikalDto.getOpis());
            artikal.setKolicina(artikalDto.getKolicina());
            artikal.setRestoran(restoran);


            this.artikalService.save(artikal);
            return "Uspesno dodavanje artikla!";
        }
        return "Nemate pravo na dodavanje arikla!";


    }

    /*@PostMapping("/izmenaArtikla/{id}")
    public String izmenaArtikla(@PathVariable(name = "id") Long id,@RequestBody ArtikalDto artikalDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.MENADZER)) {

            Artikal artikal = new Artikal();
            Menadzer menadzer = new Menadzer(prijavljenKorisnik);

            Restoran restoran = menadzer.getRestoran();

            artikal.setNaziv(artikalDto.getNaziv());
            artikal.setCena(artikalDto.getCena());
            artikal.setTipArtikla(artikalDto.getTipArtikla());
            artikal.setOpis(artikalDto.getOpis());
            artikal.setKolicina(artikalDto.getKolicina());
            artikal.setRestoran(restoran);


            this.artikalService.save(artikal);
            return "Uspesna izmena artikla!";
        }
        return "Nemate pravo na izmenu arikla!";
    }*/
}
