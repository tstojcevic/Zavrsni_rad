package hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Smjestaj extends Entitet {

    private String vrsta;
    private int brojKreveta;
    private BigDecimal cijena;
    private boolean raspolozivost;

    @ManyToMany(mappedBy = "smjestaji")
    private List<Rezervacija> rezervacije = new ArrayList<>();

    public Smjestaj() {
        super();
    }

    public Smjestaj(int sifra, String vrsta, int brojKreveta, BigDecimal cijena, boolean raspolozivost) {
        super(sifra);
        this.vrsta = vrsta;
        this.brojKreveta = brojKreveta;
        this.cijena = cijena;
        this.raspolozivost = raspolozivost;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public boolean isRaspolozivost() {
        return raspolozivost;
    }

    public void setRaspolozivost(boolean raspolozivost) {
        this.raspolozivost = raspolozivost;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public String toString() {

        return vrsta;
    }

}
