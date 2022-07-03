package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vezbe.demo.dto.ArtikalDto;
import vezbe.demo.model.Artikal;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.ArtikalRepository;
import vezbe.demo.repository.MenadzerRepository;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.Set;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    public Artikal save(Artikal artikal){
        return artikalRepository.save(artikal);
    }

    public String dodavanjeArtikala(ArtikalDto artikalDto, Korisnik prijavljenKorisnik){
        Menadzer menadzer = new Menadzer(prijavljenKorisnik);
        Artikal artikal = new Artikal();
        Restoran restoran =menadzer.getRestoran();

        artikal.setNaziv(artikalDto.getNaziv());
        artikal.setCena(artikalDto.getCena());
        artikal.setTipArtikla(artikalDto.getTipArtikla());
        artikal.setOpis(artikalDto.getOpis());
        artikal.setKolicina(artikalDto.getKolicina());
        artikal.setRestoran(restoran);


        save(artikal);

        return "Uspesno dodavanje artikla!";
    }


}
