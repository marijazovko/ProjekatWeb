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


    @GetMapping("/pocetnaRestorani")
    public ResponseEntity<List<RestoranDto>> getRestorani(){
        List<Restoran> restoraniList = restoranService.findAll();

        List<RestoranDto> dtos = new ArrayList<>();
        for(Restoran restoran : restoraniList){
            RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/pretragaPoNazivu")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoNazivu(@RequestBody RestoranDto restoranDto){
        List<Restoran> restoraniList = restoranService.findAll();

        List<RestoranDto> dtos = new ArrayList<>();
        for(Restoran restoran : restoraniList){
            if(restoran.getNaziv().equals(restoranDto.getNaziv())){
                RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/pretragaPoTipuRestorana")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoTipuRestorana(@RequestBody RestoranDto restoranDto){
        List<Restoran> restoraniList = restoranService.findAll();

        List<RestoranDto> dtos = new ArrayList<>();
        for(Restoran restoran : restoraniList){
            if(restoran.getTipRestorana().equals(restoranDto.getTipRestorana())){
                RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }
        return ResponseEntity.ok(dtos);
    }
    @PostMapping("/pretragaPoLokaciji")
    public ResponseEntity<List<RestoranDto>> getRestoraniPoLokaciji(@RequestBody RestoranDto restoranDto){
        List<Restoran> restoraniList = restoranService.findAll();

        List<RestoranDto> dtos = new ArrayList<>();
        for(Restoran restoran : restoraniList){
            if(restoran.getLokacija().getAdresa().equals(restoranDto.getLokacija().getAdresa())){
                RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }
        return ResponseEntity.ok(dtos);
    }

}
