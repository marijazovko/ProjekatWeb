package vezbe.demo.dto;

import com.sun.istack.NotNull;
import vezbe.demo.model.Korisnik;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class RegistracijaDto {

    @NotNull
    private String korisnickoIme;

    @NotNull
    private String lozinka;

    @NotNull
    private String ime;

    @NotNull
    private String prezime;


    public enum Pol {
        MUSKI,
        ZENSKI,
        OSTALO
    }
    @NotNull
    private Korisnik.Pol pol;

    @NotNull
    private Date datumRodjenja;

    public RegistracijaDto() {
    }

    public RegistracijaDto(String korisnickoIme, String lozinka, String ime, String prezime, Korisnik.Pol pol, Date datumRodjenja) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
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
}
