package vezbe.demo.dto;

import vezbe.demo.model.Artikal;
import vezbe.demo.model.Restoran;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class ArtikalDto {

    private String naziv;

    private double cena;

    public enum TipArtikla {
        Jelo,
        Pice
    }

    private Artikal.TipArtikla tipArtikla;

    private double kolicina;

    private String opis;

    //private int slika;

    public ArtikalDto() {
    }

    public ArtikalDto(String naziv, double cena, Artikal.TipArtikla tipArtikla, double kolicina, String opis, int slika) {
        this.naziv = naziv;
        this.cena = cena;
        this.tipArtikla = tipArtikla;
        this.kolicina = kolicina;
        this.opis = opis;
        //this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Artikal.TipArtikla getTipArtikla() {
        return tipArtikla;
    }

    public void setTipArtikla(Artikal.TipArtikla tipArtikla) {
        this.tipArtikla = tipArtikla;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

   /* public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }*/
}
