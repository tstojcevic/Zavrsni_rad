package stojcevic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rezervacija extends Entitet{
	
	private Date datumPrijave;
	private Date datumOdjave;
	private int brojGostiju;
	private String brojRezervacije;
	private int brojSmjestajnihJedinica;
	private List<Gost> gosti;
	
	
	
	public Rezervacija() {
		super();
		gosti = new ArrayList<>();
	}
	public Rezervacija(int sifra, Date datumPrijave, Date datumOdjave, int brojGostiju, String brojRezervacije,
			int brojSmjestajnihJedinica, Gost gost) {
		super(sifra);
		this.datumPrijave = datumPrijave;
		this.datumOdjave = datumOdjave;
		this.brojGostiju = brojGostiju;
		this.brojRezervacije = brojRezervacije;
		this.brojSmjestajnihJedinica = brojSmjestajnihJedinica;
		this.gosti = gosti;
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
	public List<Gost> getGosti() {
		return gosti;
	}
	public void setGosti(List<Gost> gosti) {
		this.gosti = gosti;
	}

}
