package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vezbe.demo.dto.LoginDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Uspesno prijavljivanje!");
    }
}
