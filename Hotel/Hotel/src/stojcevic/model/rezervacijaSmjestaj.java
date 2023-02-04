package stojcevic.model;

public class rezervacijaSmjestaj extends Entitet{
	
	private Rezervacija rezervacija;
	private Smjestaj smjestaj;
	
	
	
	public rezervacijaSmjestaj() {
		super();
	}
	public rezervacijaSmjestaj(int sifra, Rezervacija rezervacija, Smjestaj smjestaj) {
		super(sifra);
		this.rezervacija = rezervacija;
		this.smjestaj = smjestaj;
	}
	public Rezervacija getRezervacija() {
		return rezervacija;
	}
	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	public Smjestaj getSmjestaj() {
		return smjestaj;
	}
	public void setSmjestaj(Smjestaj smjestaj) {
		this.smjestaj = smjestaj;
	}
	
	
	

}
