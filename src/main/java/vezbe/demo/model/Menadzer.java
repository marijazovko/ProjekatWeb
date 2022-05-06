package vezbe.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {

    @OneToOne
    private Restoran restoran;


    public Menadzer() {
    }

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    @Override
    public String toString() {
        return "Menadzer{" +
                "restoran=" + restoran +
                '}';
    }
}
