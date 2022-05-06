package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;

public class TipKupca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private float popust;

    @Column
    private int bodovi;

    @OneToMany
    private Kupac kupac;

    public TipKupca() {
    }

    public TipKupca(String ime, float popust, int bodovi) {
        this.ime = ime;
        this.popust = popust;
        this.bodovi = bodovi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public float getPopust() {
        return popust;
    }

    public void setPopust(float popust) {
        this.popust = popust;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String toString() {
        return "TipKupca{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", popust=" + popust +
                ", bodovi=" + bodovi +
                ", kupac=" + kupac +
                '}';
    }
}
