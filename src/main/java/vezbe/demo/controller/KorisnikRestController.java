package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.LoginDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Uspesno prijavljivanje!");
    }

    @GetMapping("/korisnici")
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
    }
}
