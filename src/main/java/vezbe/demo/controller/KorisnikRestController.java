package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.LoginDto;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.service.KorisnikService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

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

        return ResponseEntity.ok(odgovor);
    }

    /*@GetMapping("/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("employee");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }*/

}
