package vezbe.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.*;

import static vezbe.demo.model.Korisnik.Pol.MUSKI;
import static vezbe.demo.model.Korisnik.Pol.ZENSKI;

@Configuration
public class DatabaseConfiguration {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private KomentarRepository komentarRepository;


    @Bean
    public boolean instantiate(){

        Korisnik korisnik = new Korisnik("peraperic", "pera123", "Pera", "Peric", Korisnik.Pol.MUSKI, new Date(1985/10/23), Korisnik.Uloga.ADMIN);
        korisnikRepository.save(korisnik);

        Menadzer menadzer = new Menadzer("zikazikic", "zika321", "Zika", "Zikic", Korisnik.Pol.MUSKI, new Date(1989/06/13), Korisnik.Uloga.MENADZER);
        menadzerRepository.save(menadzer);

        Dostavljac dostavljac1 = new Dostavljac("milamilic", "milic245","Mila", "Milic", 1, new Date(1992, 07, 12), 2);
        Dostavljac dostavljac2 = new Dostavljac("mikimikic", "miki999", "Miki", "Mikic", 0, new Date(1990,11,02), 2);
        dostavljacRepository.save(dostavljac1);
        dostavljacRepository.save(dostavljac2);

        Kupac kupac1 = new Kupac("janicjana", "jana1911", "Jana", "Janic", 1, new Date(1999,11,19), 3, 0);
        Kupac kupac2 = new Kupac("anaanic", "anic332", "Ana", "Anic", 1, new Date(2000,02,12), 3, 10);
        Kupac kupac3 = new Kupac("jovanovicj", "jovan01", "Jovan", "Jovanovic", 0, new Date(2001,01,01), 3, 15);
        kupacRepository.save(kupac1);
        kupacRepository.save(kupac2);
        kupacRepository.save(kupac3);

        TipKupca tipKupca1 = new TipKupca("Zlatni", 20, 5);
        TipKupca tipKupca2 = new TipKupca("Srebrni", 15, 0);
        tipKupca1.setKupac(kupac2);
        tipKupca1.setKupac(kupac3);
        tipKupca2.setKupac(kupac1);
        tipKupcaRepository.save(tipKupca1);
        tipKupcaRepository.save(tipKupca2);

        Lokacija lokacija1 = new Lokacija(191232, 234521, "Bulevar Evrope 53");
        Lokacija lokacija2 = new Lokacija(182342, 243214, "Vase Stajica 21");
        lokacijaRepository.save(lokacija1);
        lokacijaRepository.save(lokacija2);

        Restoran restoran1 = new Restoran("KFC", "brza hrana");
        Restoran restoran2 = new Restoran("Dva stapica", "kineska hrana");
        restoranRepository.save(restoran1);
        restoranRepository.save(restoran2);
        restoran1.setLokacija(lokacija1);
        restoran2.setLokacija(lokacija2);

        Artikal artikal1 = new Artikal("mala korpica", 500, 1, "5 ljuta pileca krilca + pomfrit + cola");
        Artikal artikal2 = new Artikal("velika korpica", 1000, 1, "10 ljutih pilecih krilca + pomfrit + cola");
        Artikal artikal3 = new Artikal("mali obrok", 450, 1, "piletina u kiselo-slatkom sosu + pirinac");
        Artikal artikal4 = new Artikal("veliki obrok", 700, 1, "piletina + povrce + pirinac");
        artikalRepository.save(artikal1);
        artikalRepository.save(artikal2);
        artikalRepository.save(artikal3);
        artikalRepository.save(artikal4);
        artikal1.setRestoran(restoran1);
        artikal2.setRestoran(restoran1);
        artikal3.setRestoran(restoran2);
        artikal4.setRestoran(restoran2);

        Porudzbina porudzbina1 = new Porudzbina();
        Porudzbina porudzbina2 = new Porudzbina();
        porudzbinaRepository.save(porudzbina1);
        porudzbinaRepository.save(porudzbina2);
        porudzbina1.setKupac(kupac1);
        porudzbina1.setDostavljac(dostavljac1);
        porudzbina1.setStatus(Porudzbina.Status.UPripremi);
        porudzbina1.setRestoran(restoran1);

        Komentar komentar1 = new Komentar("sve preporuke", 5);
        Komentar komentar2 = new Komentar("piletina nije dovoljno pecena", 3);
        komentarRepository.save(komentar1);
        komentarRepository.save(komentar2);
        komentar1.setRestoran(restoran2);
        komentar1.setKupac(kupac1);
        komentar2.setRestoran(restoran1);
        komentar2.setKupac(kupac2);

        return true;
    }


}