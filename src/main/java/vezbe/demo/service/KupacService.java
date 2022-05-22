package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Kupac;
import vezbe.demo.repository.KupacRepository;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;

    public Kupac save(Kupac kupac){
        return kupacRepository.save(kupac);
    }
}
