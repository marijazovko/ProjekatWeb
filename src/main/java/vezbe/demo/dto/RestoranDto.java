package vezbe.demo.dto;

import vezbe.demo.model.Lokacija;
import vezbe.demo.model.Restoran;

import javax.persistence.Column;

public class RestoranDto {

    private String naziv;

    private String tipRestorana;

    private Lokacija lokacija;

    public RestoranDto() {
    }

    public RestoranDto(String naziv, String tipRestorana, Lokacija lokacija) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.lokacija = lokacija;
    }

    public RestoranDto(Restoran restoran) {

    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
