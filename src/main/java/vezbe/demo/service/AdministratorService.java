package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.KorisnikDto;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.KorisnikRepository;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public String ispisSvihKorisnika(List<KorisnikDto> dtos){
        List<Korisnik> korisnikList = findAll();

        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(),korisnik.getPol(), korisnik.getDatumRodjenja(), korisnik.getUloga());
            dtos.add(dto);
        }
        return null;
    }


    public String pretragaPoKorisnickomImenu (List<KorisnikDto> dtos, KorisnikDto korisnikDto){
        List<Korisnik> korisniciList = findAll();

        for(Korisnik korisnik : korisniciList){
            if(korisnik.getKorisnickoIme().equals(korisnikDto.getKorisnickoIme())) {
                KorisnikDto dto = new KorisnikDto(korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(),korisnik.getPol(), korisnik.getDatumRodjenja(), korisnik.getUloga());
                dtos.add(dto);
            }
        }
        return null;
    }

    public String pretragaPoImenu (List<KorisnikDto> dtos, KorisnikDto korisnikDto){
        List<Korisnik> korisniciList = findAll();

        for(Korisnik korisnik : korisniciList){
            if(korisnik.getIme().equals(korisnikDto.getIme())) {
                KorisnikDto dto = new KorisnikDto(korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(),korisnik.getPol(), korisnik.getDatumRodjenja(), korisnik.getUloga());
                dtos.add(dto);
            }
        }
        return null;
    }
    public String pretragaPoPrezimenu (List<KorisnikDto> dtos, KorisnikDto korisnikDto){
        List<Korisnik> korisniciList = findAll();

        for(Korisnik korisnik : korisniciList){
            if(korisnik.getPrezime().equals(korisnikDto.getPrezime())) {
                KorisnikDto dto = new KorisnikDto(korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(),korisnik.getPol(), korisnik.getDatumRodjenja(), korisnik.getUloga());
                dtos.add(dto);
            }
        }
        return null;
    }

}
