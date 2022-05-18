package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StavkaPorudzbine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    int kolicina;

    @ManyToOne
    private Artikal artikal;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
}
