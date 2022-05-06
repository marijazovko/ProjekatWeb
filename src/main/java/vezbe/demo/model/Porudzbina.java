package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID UIID;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)//nova klasa koja ima artikal i kolicinu
    private Set<Artikal> poruceniArtikli= new HashSet<>();

    @ManyToOne
    private Dostavljac dostavljac;

    @ManyToOne
    private Restoran restoran;

    @Column
    private Date datumIVreme;

    @Column
    private double cena;

    @ManyToOne
    private Kupac kupac;

    public enum Status {
        Obrada,
        UPripremi,
        CekaDostavljaca,
        UTransportu,
        Dostavljena,
        Otkazana
    }

    @Column
    private Status status;

    public Porudzbina() {
    }

    public UUID getUIID() {
        return UIID;
    }

    public void setUIID(UUID UIID) {
        this.UIID = UIID;
    }

    public Set<Artikal> getPoruceniArtikli() {
        return poruceniArtikli;
    }

    public void setPoruceniArtikli(Set<Artikal> poruceniArtikli) {
        this.poruceniArtikli = poruceniArtikli;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Porudzbina{" +
                ", UIID=" + UIID +
                ", poruceniArtikli=" + poruceniArtikli +
                ", dostavljac=" + dostavljac +
                ", restoran=" + restoran +
                ", datumIVreme=" + datumIVreme +
                ", cena=" + cena +
                ", kupac=" + kupac +
                ", status=" + status +
                '}';
    }
}
