package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double geografskaDuzina;

    @Column
    private double geografskaSirina;

    @Column
    private String adresa;

    @OneToOne
    private Restoran restoran;

    public Lokacija() {
    }

    public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
        this.geografskaDuzina = geografskaDuzina;
        this.geografskaSirina = geografskaSirina;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGeografskaDuzina() {
        return geografskaDuzina;
    }

    public void setGeografskaDuzina(double geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public double getGeografskaSirina() {
        return geografskaSirina;
    }

    public void setGeografskaSirina(double geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    @Override
    public String toString() {
        return "Lokacija{" +
                "id=" + id +
                ", geografskaDuzina=" + geografskaDuzina +
                ", geografskaSirina=" + geografskaSirina +
                ", adresa='" + adresa + '\'' +
                ", restoran=" + restoran +
                '}';
    }
}
