package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String tipRestorana;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Artikal> artikliUPonudi = new HashSet<>();

    @OneToOne
    private Lokacija lokacija;

    @OneToOne
    @JoinColumn(name = "menadzer_id")
    private Menadzer menadzer;

    @OneToMany
    private Set <Porudzbina> porudzbina = new HashSet<>();

    @OneToMany
    private Set <Komentar> komentar = new HashSet<>();


    public Restoran() {
    }

    public Restoran(String naziv, String tipRestorana) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
    }

    public Restoran(Restoran restoran) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Artikal> getArtikliUPonudi() {
        return artikliUPonudi;
    }

    public void setArtikliUPonudi(Set<Artikal> artikliUPonudi) {
        this.artikliUPonudi = artikliUPonudi;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public Set<Porudzbina> getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Set<Porudzbina> porudzbina) {
        this.porudzbina = porudzbina;
    }

    public Set<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(Set<Komentar> komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", tipRestorana='" + tipRestorana + '\'' +
                ", artikliUPonudi=" + artikliUPonudi +
                ", lokacija=" + lokacija +
                ", menadzer=" + menadzer +
                ", porudzbina=" + porudzbina +
                ", komentar=" + komentar +
                '}';
    }

}
