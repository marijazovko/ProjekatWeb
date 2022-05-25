package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Kupac;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.RestoranRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    public List<Restoran> findAll(){
        return restoranRepository.findAll();
    }

    public Restoran findOne(Long id){
        Optional<Restoran> foundRestoran = restoranRepository.findById(id);
        if (foundRestoran.isPresent())
            return foundRestoran.get();

        return null;
    }

    public Restoran save(Restoran restoran){
        return restoranRepository.save(restoran);
    }

    public String kreiranjeRestorana (RestoranDto restoranDto){
        Restoran restoran = new Restoran();

        restoran.setNaziv(restoranDto.getNaziv());
        restoran.setTipRestorana(restoranDto.getTipRestorana());
        //restoran.setLokacija(restoranDto.getLokacija());

        save(restoran);

        return null;
    }
    public String pocetnaRestorani(List<RestoranDto> dtos){
        List<Restoran> restoraniList = findAll();

        for(Restoran restoran : restoraniList){
            RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
            dtos.add(dto);
        }
        return null;
    }

    public String pretragaPoNazivu (List<RestoranDto> dtos, RestoranDto restoranDto){
        List<Restoran> restoraniList = findAll();

        for(Restoran restoran : restoraniList){
            if(restoran.getNaziv().equals(restoranDto.getNaziv())) {
                RestoranDto dto = new RestoranDto(restoran.getNaziv(), restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }
        return null;
    }

    public String pretragaPoTipuRestorana (List<RestoranDto> dtos, RestoranDto restoranDto){
        List<Restoran> restoraniList = findAll();

        for(Restoran restoran : restoraniList){
            if(restoran.getTipRestorana().equals(restoranDto.getTipRestorana())){
                RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }
        return null;
    }

    public String pretragaPoLokaciji (List<RestoranDto> dtos, RestoranDto restoranDto) {
        List<Restoran> restoraniList = findAll();

        for(Restoran restoran : restoraniList){
            if(restoran.getLokacija().getAdresa().equals(restoranDto.getLokacija().getAdresa())){
                RestoranDto dto = new RestoranDto(restoran.getNaziv(),restoran.getTipRestorana(), restoran.getLokacija());
                dtos.add(dto);
            }
        }

        return  null;
    }

}
