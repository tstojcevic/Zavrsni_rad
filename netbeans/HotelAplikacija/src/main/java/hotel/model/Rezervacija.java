package hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Rezervacija extends Entitet {

	private Date datumPrijave;
	private Date datumOdjave;
	private int brojGostiju;
	private String brojRezervacije;
	private int brojSmjestajnihJedinica;
        @ManyToOne
	private Gost gost;
        @ManyToMany
        @JoinTable(name = "Rezervacija_Djelatnik",
            joinColumns = {
                @JoinColumn(name = "rezervacija")},
            inverseJoinColumns = {
                @JoinColumn(name = "djelatnik")})
	private List<Djelatnik> djelatnici;
        @ManyToMany
        @JoinTable(name = "Rezervacija_Smjestaj",
            joinColumns = {
                @JoinColumn(name = "rezervacija")},
            inverseJoinColumns = {
                @JoinColumn(name = "smjestaj")})
	private List<Smjestaj> smjestaji;

	public Rezervacija() {
		super();
		djelatnici = new ArrayList<>();
		smjestaji = new ArrayList<>();
	}

	public Rezervacija(int sifra, Date datumPrijave, Date datumOdjave, int brojGostiju, String brojRezervacije,
			int brojSmjestajnihJedinica, Gost gost, List<Djelatnik> djelatnici, List<Smjestaj> smjestaji) {
		super(sifra);
		this.datumPrijave = datumPrijave;
		this.datumOdjave = datumOdjave;
		this.brojGostiju = brojGostiju;
		this.brojRezervacije = brojRezervacije;
		this.brojSmjestajnihJedinica = brojSmjestajnihJedinica;
		this.gost = gost;
		this.djelatnici = djelatnici;
		this.smjestaji = smjestaji;
	}

	public Date getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Date getDatumOdjave() {
		return datumOdjave;
	}

	public void setDatumOdjave(Date datumOdjave) {
		this.datumOdjave = datumOdjave;
	}

	public int getBrojGostiju() {
		return brojGostiju;
	}

	public void setBrojGostiju(int brojGostiju) {
		this.brojGostiju = brojGostiju;
	}

	public String getBrojRezervacije() {
		return brojRezervacije;
	}

	public void setBrojRezervacije(String brojRezervacije) {
		this.brojRezervacije = brojRezervacije;
	}

	public int getBrojSmjestajnihJedinica() {
		return brojSmjestajnihJedinica;
	}

	public void setBrojSmjestajnihJedinica(int brojSmjestajnihJedinica) {
		this.brojSmjestajnihJedinica = brojSmjestajnihJedinica;
	}

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public List<Djelatnik> getDjelatnici() {
		return djelatnici;
	}

	public void setDjelatnici(List<Djelatnik> djelatnici) {
		this.djelatnici = djelatnici;
	}

	public List<Smjestaj> getSmjestaji() {
		return smjestaji;
	}

	public void setSmjestaji(List<Smjestaj> smjestaji) {
		this.smjestaji = smjestaji;
	}
	
	@Override
	public String toString() {
		return brojRezervacije + ", " + datumPrijave + " - " + datumOdjave;
	}

}
