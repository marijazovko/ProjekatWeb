package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Kupac kupac;

    @ManyToOne
    private Restoran restoran;

    @Column
    private String komentar;

    @Column
    private int ocena;

    public Komentar() {
    }

    public Komentar(String komentar, int ocena) {
        this.komentar = komentar;
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Komentar{" +
                "id=" + id +
                ", kupac=" + kupac +
                ", restoran=" + restoran +
                ", komentar='" + komentar + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
