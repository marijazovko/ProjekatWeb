package vezbe.demo.dto;

import vezbe.demo.model.Korisnik;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class KorisnikDto {
    private String korisnickoIme;

    private String lozinka;

    private String ime;

    private String prezime;

    public KorisnikDto(Korisnik korisnik) {
    }


    public enum Pol {
        MUSKI,
        ZENSKI,
        OSTALO
    }

    private Korisnik.Pol pol;

    private Date datumRodjenja;

    public enum Uloga {
        ADMIN,
        MENADZER,
        DOSTAVLJAC,
        KUPAC
    }

    private Korisnik.Uloga uloga;

    public KorisnikDto() {
    }

    public KorisnikDto(String korisnickoIme, String lozinka, String ime, String prezime, Korisnik.Pol pol, Date datumRodjenja, Korisnik.Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }
    public KorisnikDto(String korisnickoIme, String ime, String prezime, Korisnik.Pol pol, Date datumRodjenja, Korisnik.Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
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

    public Korisnik.Pol getPol() {
        return pol;
    }

    public void setPol(Korisnik.Pol pol) {
        this.pol = pol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Korisnik.Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Korisnik.Uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "KorisnikDto{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pol=" + pol +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                '}';
    }
}
