package vezbe.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {

    @OneToOne(mappedBy = "menadzer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga, Restoran restoran, Restoran restoran1) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga, restoran);
        this.restoran = restoran1;
    }

    public Menadzer() {
    }

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
    }

    public Menadzer(Korisnik prijavljenKorisnik) {
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
