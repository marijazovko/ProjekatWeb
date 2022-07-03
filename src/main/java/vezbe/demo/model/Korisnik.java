package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String korisnickoIme;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga, Restoran restoran) {
    }

    public enum Pol {
        MUSKI,
        ZENSKI,
        OSTALO
    }

    @Column
    private Pol pol;

    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;

    public enum Uloga {
        ADMIN,
        MENADZER,
        DOSTAVLJAC,
        KUPAC
    }

    @Column
    private Uloga uloga;


    public Korisnik() {
    }

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pol=" + pol +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                '}';
    }
}
