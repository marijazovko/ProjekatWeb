package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Artikal;
import vezbe.demo.model.Korisnik;
import vezbe.demo.repository.ArtikalRepository;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;

    public Artikal save(Artikal artikal){
        return artikalRepository.save(artikal);
    }
}
