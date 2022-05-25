package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Restoran;
import vezbe.demo.service.KorisnikService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;

    @PostMapping("/kreiranjeRestorana")
    public String kreiranjeRestorana(@RequestBody RestoranDto restoranDto, HttpSession session) {
        Korisnik prijavljenKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(prijavljenKorisnik.getUloga().equals(Korisnik.Uloga.ADMIN)) {
            this.restoranService.kreiranjeRestorana(restoranDto);
            return "Uspesno kreiranje restorana!";
        }
        return "Nemate pravo na kreiranje restorana!";
    }


    @GetMapping("/pocetnaRestorani")
    public ResponseEntity<List<RestoranDto>> getRestorani(){
        List<RestoranDto> dtos = new ArrayList<>();
        this.restoranService.pocetnaRestorani(dtos);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/pretragaPoNazivu")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoNazivu(@RequestBody RestoranDto restoranDto){

        List<RestoranDto> dtos = new ArrayList<>();
        this.restoranService.pretragaPoNazivu(dtos, restoranDto);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/pretragaPoTipuRestorana")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoTipuRestorana(@RequestBody RestoranDto restoranDto){

        List<RestoranDto> dtos = new ArrayList<>();
        this.restoranService.pretragaPoTipuRestorana(dtos, restoranDto);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/pretragaPoLokaciji")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoLokaciji(@RequestBody RestoranDto restoranDto){

        List<RestoranDto> dtos = new ArrayList<>();
        this.restoranService.pretragaPoLokaciji(dtos, restoranDto);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/ispisIzabranogRestorana/{id}")
    public Restoran getRestoran(@PathVariable(name = "id") Long id){
        Restoran restoran = restoranService.findOne(id);
        return restoran;
    }

}
