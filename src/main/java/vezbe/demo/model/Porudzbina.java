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
    @GeneratedValue
    private UUID id;

    @OneToMany
    private Set<StavkaPorudzbine> stavkaPorudzbine = new HashSet<>();

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

    public Porudzbina(Date datumIVreme, double cena, Status status) {
        this.datumIVreme = datumIVreme;
        this.cena = cena;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<StavkaPorudzbine> getStavkaPorudzbine() {
        return stavkaPorudzbine;
    }

    public void setStavkaPorudzbine(Set<StavkaPorudzbine> stavkaPorudzbine) {
        this.stavkaPorudzbine = stavkaPorudzbine;
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
                ", UIID=" + id +
                ", stavkaPorudzbine=" + stavkaPorudzbine +
                ", dostavljac=" + dostavljac +
                ", restoran=" + restoran +
                ", datumIVreme=" + datumIVreme +
                ", cena=" + cena +
                ", kupac=" + kupac +
                ", status=" + status +
                '}';
    }

}
