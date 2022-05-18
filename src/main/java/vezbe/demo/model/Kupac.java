package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @Column
    private int sakupljeniBodovi;

    @ManyToOne
    private TipKupca tipKupca;

    @OneToMany
    private Set <Komentar> komentar = new HashSet<>();

    public Kupac() {
    }

    public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga, int sakupljeniBodovi) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
        this.sakupljeniBodovi = sakupljeniBodovi;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    public int getSakupljeniBodovi() {
        return sakupljeniBodovi;
    }

    public void setSakupljeniBodovi(int sakupljeniBodovi) {
        this.sakupljeniBodovi = sakupljeniBodovi;
    }

    public TipKupca getTipKupca() {
        return tipKupca;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
    }

    public Set<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(Set<Komentar> komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return "Kupac{" +
                "porudzbine=" + porudzbine +
                ", sakupljeniBodovi=" + sakupljeniBodovi +
                ", tipKupca=" + tipKupca +
                ", komentar=" + komentar +
                '}';
    }
}
