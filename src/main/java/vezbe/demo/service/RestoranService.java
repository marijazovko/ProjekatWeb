package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.RestoranRepository;

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


}
