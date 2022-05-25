package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.RegistracijaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.service.KupacService;

@RestController
public class KupacRestController {

    @Autowired
    private KupacService kupacService;

    @PostMapping("/registracija")
    public ResponseEntity registraija(@RequestBody RegistracijaDto registracijaDto) {
        this.kupacService.registraija(registracijaDto);
        return new ResponseEntity("Uspesna registracija!", HttpStatus.OK);
    }

}
