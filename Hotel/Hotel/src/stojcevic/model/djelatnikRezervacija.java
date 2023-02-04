package stojcevic.model;

public class djelatnikRezervacija extends Entitet{
	
	private Rezervacija rezervacija;
	private Djelatnik djelatnik;
	
	
	
	public djelatnikRezervacija() {
		super();
	}
	public djelatnikRezervacija(int sifra, Rezervacija rezervacija, Djelatnik djelatnik) {
		super(sifra);
		this.rezervacija = rezervacija;
		this.djelatnik = djelatnik;
	}
	public Rezervacija getRezervacija() {
		return rezervacija;
	}
	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	public Djelatnik getDjelatnik() {
		return djelatnik;
	}
	public void setDjelatnik(Djelatnik djelatnik) {
		this.djelatnik = djelatnik;
	}
	
	

}
