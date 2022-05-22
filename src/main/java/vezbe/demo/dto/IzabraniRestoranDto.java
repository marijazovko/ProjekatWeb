package vezbe.demo.dto;

import vezbe.demo.model.Artikal;
import vezbe.demo.model.Komentar;
import vezbe.demo.model.Lokacija;

import java.util.HashSet;
import java.util.Set;

public class IzabraniRestoranDto {
    private String naziv;

    private String tipRestorana;

    enum Status {
        RADI, NE_RADI
    }

    private Status status;

    private Lokacija lokacija;

    private int ocena;

    private Komentar komentar;

    private Set<Artikal> artikliUPonudi = new HashSet<>();

    public IzabraniRestoranDto() {
    }

    public IzabraniRestoranDto(String naziv, String tipRestorana, Status status, Lokacija lokacija, int ocena, Komentar komentar, Set<Artikal> artikliUPonudi) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.status = status;
        this.lokacija = lokacija;
        this.ocena = ocena;
        this.komentar = komentar;
        this.artikliUPonudi = artikliUPonudi;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Komentar getKomentar() {
        return komentar;
    }

    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }

    public Set<Artikal> getArtikliUPonudi() {
        return artikliUPonudi;
    }

    public void setArtikliUPonudi(Set<Artikal> artikliUPonudi) {
        this.artikliUPonudi = artikliUPonudi;
    }

    @Override
    public String toString() {
        return "IzabraniRestoranDto{" +
                "naziv='" + naziv + '\'' +
                ", tipRestorana='" + tipRestorana + '\'' +
                ", status=" + status +
                ", lokacija=" + lokacija +
                ", ocena=" + ocena +
                ", komentar=" + komentar +
                ", artikliUPonudi=" + artikliUPonudi +
                '}';
    }
}
